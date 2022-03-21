package com.companyname.ofbizdemo.services;

import org.apache.ofbiz.base.util.Debug;

import java.util.LinkedList;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.List;

import org.apache.ofbiz.entity.model.DynamicViewEntity;
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
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilDateTime;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilProperties;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.common.KeywordSearchUtil;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericDelegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.condition.EntityComparisonOperator;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityConditionParam;
import org.apache.ofbiz.entity.condition.EntityConditionSubSelect;
import org.apache.ofbiz.entity.condition.EntityConditionValue;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.entity.config.model.EntityConfig;
import org.apache.ofbiz.entity.model.DynamicViewEntity;
import org.apache.ofbiz.entity.model.ModelKeyMap;
import org.apache.ofbiz.entity.model.ModelViewEntity.ComplexAlias;
import org.apache.ofbiz.entity.model.ModelViewEntity.ComplexAliasField;
import org.apache.ofbiz.entity.transaction.GenericTransactionException;
import org.apache.ofbiz.entity.transaction.TransactionUtil;
import org.apache.ofbiz.entity.util.EntityListIterator;
import org.apache.ofbiz.entity.util.EntityQuery;
import org.apache.ofbiz.entity.util.EntityUtil;
import org.apache.ofbiz.party.party.PartyHelper;
import org.apache.ofbiz.product.category.CategoryContentWrapper;
import org.apache.ofbiz.service.LocalDispatcher;


public class SupplierDemoService {
    private static final String RESOURCE = "PartyUiLabels";
    private static final String RES_ERROR = "PartyErrorUiLabels";
    private static final String MODULE = SupplierDemoService.class.getName();

    public static Map<String, Object> trainingCreateSupplier(DispatchContext ctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = new HashMap<>();
        LocalDispatcher dispatcher = ctx.getDispatcher();
        String partyId = null;

        try {

            Map<String, Object> serviceCtx = ctx.makeValidContext("createPartyGroup", ModelService.IN_PARAM, context);
            result = dispatcher.runSync("createPartyGroup", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

            partyId = String.valueOf(result.get("partyId"));

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

            String emailPreContactMechTypeId = "EMAIL_ADDRESS";
            String emailContactMechTypeId = "EMAIL_ADDRESS";
            String emailContactMechPurposeTypeId = "PRIMARY_EMAIL";

            serviceCtx.put("contactMechTypeId", emailContactMechTypeId);
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("preContactMechTypeId", emailPreContactMechTypeId);
            serviceCtx.put("contactMechPurposeTypeId", emailContactMechPurposeTypeId);


            result = dispatcher.runSync("createPartyEmailAddress", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

            serviceCtx = ctx.makeValidContext("createPartyTelecomNumber", ModelService.IN_PARAM, context);

            String telecomPreContactMechTypeId = "TELECOM_NUMBER";
            String telecomContactMechTypeId = "TELECOM_NUMBER";
            String telecomContactMechPurposeTypeId = "PRIMARY_PHONE";

            serviceCtx.put("partyId", partyId);
            serviceCtx.put("contactMechTypeId", telecomContactMechTypeId);
            serviceCtx.put("preContactMechTypeId", telecomPreContactMechTypeId);
            serviceCtx.put("contactMechPurposeTypeId", telecomContactMechPurposeTypeId);

            result = dispatcher.runSync("createPartyTelecomNumber", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

            serviceCtx = ctx.makeValidContext("createPartyPostalAddress", ModelService.IN_PARAM, context);

            String addressPreContactMechTypeId = "POSTAL_ADDRESS";
            String addressContactMechTypeId = "POSTAL_ADDRESS";
            String addressContactMechPurposeTypeId = "PRIMARY_LOCATION";

            serviceCtx.put("partyId", partyId);
            serviceCtx.put("contactMechTypeId", addressContactMechTypeId);
            serviceCtx.put("preContactMechTypeId", addressPreContactMechTypeId);
            serviceCtx.put("contactMechPurposeTypeId", addressContactMechPurposeTypeId);

            result = dispatcher.runSync("createPartyPostalAddress", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError(e.getMessage());

        }
        return ServiceUtil.returnSuccess();
    }

    public static Map<String, Object> trainingUpdateSupplierDetail(DispatchContext ctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = new HashMap<>();
        LocalDispatcher dispatcher = ctx.getDispatcher();

        try {
            Map<String, Object> serviceCtx = ctx.makeValidContext("updatePartyGroup", ModelService.IN_PARAM, context);
            result = dispatcher.runSync("updatePartyGroup", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

            serviceCtx = ctx.makeValidContext("updatePartyEmailAddress", ModelService.IN_PARAM, context);
            serviceCtx.put("contactMechId", (String) context.get("emailContactMechId"));
            result = dispatcher.runSync("updatePartyEmailAddress", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

            serviceCtx = ctx.makeValidContext("updatePartyTelecomNumber", ModelService.IN_PARAM, context);
            serviceCtx.put("contactMechId", (String) context.get("phoneContactMechId"));
            result = dispatcher.runSync("updatePartyTelecomNumber", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError(e.getMessage());
        }
        return ServiceUtil.returnSuccess();
    }

    public static Map<String, Object> trainingUpdateSupplierPostalAddress(DispatchContext ctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = new HashMap<>();
        LocalDispatcher dispatcher = ctx.getDispatcher();
        try {
            Map<String, Object> serviceCtx = ctx.makeValidContext("updatePartyPostalAddress", ModelService.IN_PARAM, context);

            result = dispatcher.runSync("updatePartyPostalAddress", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }

        } catch (GenericServiceException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError(e.getMessage());
        }
        return ServiceUtil.returnSuccess();
    }
}