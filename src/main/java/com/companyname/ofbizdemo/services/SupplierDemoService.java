package com.companyname.ofbizdemo.services;

import org.apache.calcite.sql.dialect.PrestoSqlDialect;
import org.apache.cxf.helpers.ServiceUtils;
import org.mozilla.javascript.Context;
import org.apache.ofbiz.base.util.Debug;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.base.util.UtilDateTime;
import org.apache.ofbiz.base.util.UtilGenerics;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilProperties;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.GenericEntity;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityFunction;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.entity.model.DynamicViewEntity;
import org.apache.ofbiz.entity.model.ModelKeyMap;
import org.apache.ofbiz.entity.util.EntityListIterator;
import org.apache.ofbiz.entity.util.EntityQuery;
import org.apache.ofbiz.entity.util.EntityTypeUtil;
import org.apache.ofbiz.entity.util.EntityUtil;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;
import org.apache.ofbiz.service.ModelService;


public class SupplierDemoService {
    private static final String RESOURCE = "PartyUiLabels";
    private static final String RES_ERROR = "PartyErrorUiLabels";
    private static final String MODULE = SupplierDemoService.class.getName();

    public static Map<String, Object> trainingCreateSupplier(DispatchContext ctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> result2 = ServiceUtil.returnSuccess();
        Delegator delegator = ctx.getDelegator();
        LocalDispatcher dispatcher = ctx.getDispatcher();
        GenericValue userLogin = (GenericValue) context.get("userLogin");
        Timestamp now = UtilDateTime.nowTimestamp();
        String partyId = null;
        Locale locale = (Locale) context.get("locale");
        String groupName = (String) context.get("groupName");
        String emailAddress = (String) context.get("email");
        String contactNumber = (String) context.get("contactNumber");
        String address1 = (String) context.get("address1");
        String address2 = (String) context.get("address2");
        String city = (String) context.get("city");
        String postalCode = (String) context.get("postalCode");
        String stateProvinceGeoId = (String) context.get("stateProvinceGeoId");
        String countryGeoId = (String) context.get("countryGeoId");

        try {
            Map<String, Object> serviceCtx = ctx.makeValidContext("createPartyGroup", ModelService.IN_PARAM, context);
            Debug.log("=====================" + serviceCtx);
            serviceCtx.put("userLogin", userLogin);


            result = dispatcher.runSync("createPartyGroup", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

            partyId = String.valueOf(result.get("partyId"));
            Debug.log("=====================" + partyId);

            serviceCtx.put("partyId", partyId);
            String partyRole = "SUPPLIER";
            serviceCtx.put("roleTypeId", partyRole);

            result = dispatcher.runSync("createPartyRole", serviceCtx);

            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx = ctx.makeValidContext("createPartyRelationship", ModelService.IN_PARAM, context);
            String partyIdFrom = "Company";
            String roleTypeIdFrom = "INTERNAL_ORGANIZATIO";
            String roleTypeIdTo = "SUPPLIER";
            String partyRelationshipTypeId = "SUPPLIER_REL";


            serviceCtx.put("partyIdTo", partyId);
            serviceCtx.put("partyIdFrom", partyIdFrom);
            serviceCtx.put("roleTypeIdFrom", roleTypeIdFrom);
            serviceCtx.put("roleTypeIdTo", roleTypeIdTo);
            serviceCtx.put("partyRelationshipTypeId", partyRelationshipTypeId);

            result = dispatcher.runSync("createPartyRelationship", serviceCtx);

            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }


            serviceCtx = ctx.makeValidContext("createPartyEmailAddress", ModelService.IN_PARAM, context);

            String preContactMechTypeId = "EMAIL_ADDRESS";
            String contactMechTypeId = "EMAIL_ADDRESS";
            String contactMechPurposeTypeId = "PRIMARY_EMAIL";

            serviceCtx.put("contactMechTypeId", contactMechTypeId);
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("preContactMechTypeId", preContactMechTypeId);
            serviceCtx.put("contactMechPurposeTypeId", contactMechPurposeTypeId);


            result = dispatcher.runSync("createPartyEmailAddress", serviceCtx);

            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

            serviceCtx = ctx.makeValidContext("createPartyTelecomNumber", ModelService.IN_PARAM, context);

            String preContactMechTypeId1 = "TELECOM_NUMBER";
            String contactMechTypeId1 = "TELECOM_NUMBER";
            String contactMechPurposeTypeId1 = "PRIMARY_PHONE";

            serviceCtx.put("partyId", partyId);
            serviceCtx.put("contactMechTypeId", contactMechTypeId1);
            serviceCtx.put("preContactMechTypeId", preContactMechTypeId1);
            serviceCtx.put("contactMechPurposeTypeId", contactMechPurposeTypeId1);

            result = dispatcher.runSync("createPartyTelecomNumber", serviceCtx);

            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

            serviceCtx = ctx.makeValidContext("createPartyPostalAddress", ModelService.IN_PARAM, context);

            String preContactMechTypeId2 = "POSTAL_ADDRESS";
            String contactMechTypeId2 = "POSTAL_ADDRESS";
            String contactMechPurposeTypeId2 = "PRIMARY_LOCATION";
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("contactMechTypeId", contactMechTypeId2);
            serviceCtx.put("preContactMechTypeId", preContactMechTypeId2);
            serviceCtx.put("contactMechPurposeTypeId", contactMechPurposeTypeId2);

            result = dispatcher.runSync("createPartyPostalAddress", serviceCtx);

            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {

        }


        result2.put(ModelService.RESPONSE_MESSAGE, ModelService.RESPOND_SUCCESS);
        return result2;
    }

}