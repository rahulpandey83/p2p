package com.companyname.ofbizdemo.services;

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
        String countryCode = (String) context.get("countryCode");
        String areaCode = (String) context.get("areaCode");
        String contactNumber = (String) context.get("contactNumber");
        String extension = (String) context.get("extension");
        String address1 = (String) context.get("address1");
        String address2 = (String) context.get("address2");
        String city = (String) context.get("city");
        String postalCode = (String) context.get("postalCode");
        String stateProvinceGeoId = (String) context.get("stateProvinceGeoId");
        String countryGeoId = (String) context.get("countryGeoId");

        Map<String, Object> processContext = new HashMap<>(context);
        Debug.log("=====================" + processContext);
        processContext.put("groupName", groupName);

        try {
            result = dispatcher.runSync("createPartyGroup", processContext);
            partyId = String.valueOf(result.get("partyId"));
            Debug.log("=====================" + partyId);
            if (ServiceUtil.isError(result)) {
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {

        }
        String preContactMechTypeId = "EMAIL_ADDRESS";
        String contactMechTypeId = "EMAIL_ADDRESS";
        String contactMechPurposeTypeId = "PRIMARY_EMAIL";
        processContext.put("emailAddress", emailAddress);
        processContext.put("contactMechTypeId", contactMechTypeId);
        processContext.put("partyId", partyId);
        processContext.put("preContactMechTypeId", preContactMechTypeId);
        processContext.put("contactMechPurposeTypeId", contactMechPurposeTypeId);

        try {
            result = dispatcher.runSync("createEmailAddress", processContext);

            if (ServiceUtil.isError(result)) {
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {

        }

        try {
            result = dispatcher.runSync("createPartyEmailAddress", processContext);

            if (ServiceUtil.isError(result)) {
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {

        }

        String preContactMechTypeId1 = "TELECOM_NUMBER";
        String contactMechTypeId1 = "TELECOM_NUMBER";
        String contactMechPurposeTypeId1 = "PRIMARY_PHONE";

        processContext.put("contactMechTypeId", contactMechTypeId1);
        processContext.put("preContactMechTypeId", preContactMechTypeId1);
        processContext.put("contactMechPurposeTypeId", contactMechPurposeTypeId1);

        processContext.put("countryCode", countryCode);
        processContext.put("areaCode", areaCode);
        processContext.put("contactNumber", contactNumber);
        processContext.put("extension", extension);

        try {
            result = dispatcher.runSync("createTelecomNumber", processContext);

            if (ServiceUtil.isError(result)) {
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {

        }

        try {
            result = dispatcher.runSync("createPartyTelecomNumber", processContext);

            if (ServiceUtil.isError(result)) {
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {

        }

        String preContactMechTypeId2 = "POSTAL_ADDRESS";
        String contactMechTypeId2 = "POSTAL_ADDRESS";
        String contactMechPurposeTypeId2 = "PRIMARY_LOCATION";

        processContext.put("contactMechTypeId", contactMechTypeId2);
        processContext.put("preContactMechTypeId", preContactMechTypeId2);
        processContext.put("contactMechPurposeTypeId", contactMechPurposeTypeId2);
        processContext.put("address1", address1);
        processContext.put("address2", address2);
        processContext.put("stateProvinceGeoId", stateProvinceGeoId);
        processContext.put("postalCode", postalCode);
        processContext.put("countryGeoId", countryGeoId);
        processContext.put("city", city);

        try {
            result = dispatcher.runSync("createPostalAddress", processContext);

            if (ServiceUtil.isError(result)) {
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {

        }

        try {
            result = dispatcher.runSync("createPartyPostalAddress", processContext);

            if (ServiceUtil.isError(result)) {
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {

        }

        processContext.clear();

        result2.put(ModelService.RESPONSE_MESSAGE, ModelService.RESPOND_SUCCESS);
        return result2;
    }

}