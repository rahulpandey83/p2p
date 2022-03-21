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
import org.apache.ofbiz.entity.util.EntityUtilProperties;


public class SupplierDemoServices {
    private static final String RESOURCE = "PartyUiLabels";
    private static final String RES_ERROR = "PartyErrorUiLabels";
    private static final String MODULE = SupplierDemoServices.class.getName();

    public static Map<String, Object> trainingCreateSupplier(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = new HashMap<>();
        LocalDispatcher dispatcher = dctx.getDispatcher();
        Delegator delegator = dctx.getDelegator();
        GenericValue userLogin = (GenericValue) context.get("userLogin");
        try {
            Map<String, Object> serviceCtx = dctx.makeValidContext("createPartyGroup", ModelService.IN_PARAM, context);
            result = dispatcher.runSync("createPartyGroup", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();
            String partyId = String.valueOf(result.get("partyId"));
            serviceCtx.put("userLogin",userLogin);
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("roleTypeId", "SUPPLIER");
            result = dispatcher.runSync("createPartyRole", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();

            serviceCtx = dctx.makeValidContext("createPartyRelationship", ModelService.IN_PARAM, context);
            serviceCtx.put("partyIdTo", partyId);
            serviceCtx.put("partyIdFrom", EntityUtilProperties.getPropertyValue("general", "ORGANIZATION_PARTY", "Company", delegator));
            serviceCtx.put("roleTypeIdFrom", "INTERNAL_ORGANIZATIO");
            serviceCtx.put("roleTypeIdTo", "SUPPLIER");
            serviceCtx.put("partyRelationshipTypeId", "SUPPLIER_REL");
            result = dispatcher.runSync("createPartyRelationship", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();

            serviceCtx = dctx.makeValidContext("createPartyEmailAddress", ModelService.IN_PARAM, context);
            serviceCtx.put("contactMechTypeId", "EMAIL_ADDRESS");
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("preContactMechTypeId", "EMAIL_ADDRESS");
            serviceCtx.put("contactMechPurposeTypeId", "PRIMARY_EMAIL");
            result = dispatcher.runSync("createPartyEmailAddress", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();

            serviceCtx = dctx.makeValidContext("createPartyTelecomNumber", ModelService.IN_PARAM, context);
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("contactMechTypeId", "TELECOM_NUMBER");
            serviceCtx.put("preContactMechTypeId", "TELECOM_NUMBER");
            serviceCtx.put("contactMechPurposeTypeId", "PRIMARY_PHONE");
            result = dispatcher.runSync("createPartyTelecomNumber", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();

            serviceCtx = dctx.makeValidContext("createPartyPostalAddress", ModelService.IN_PARAM, context);
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("contactMechTypeId", "POSTAL_ADDRESS");
            serviceCtx.put("preContactMechTypeId", "POSTAL_ADDRESS");
            serviceCtx.put("contactMechPurposeTypeId", "PRIMARY_LOCATION");
            result = dispatcher.runSync("createPartyPostalAddress", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();

        } catch (GenericServiceException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError(e.getMessage());

        }
        return ServiceUtil.returnSuccess();
    }

    public static Map<String, Object> trainingUpdateSupplierDetail(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = new HashMap<>();
        LocalDispatcher dispatcher = dctx.getDispatcher();

        try {
            Map<String, Object> serviceCtx = dctx.makeValidContext("updatePartyGroup", ModelService.IN_PARAM, context);
            result = dispatcher.runSync("updatePartyGroup", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();
            serviceCtx = dctx.makeValidContext("updatePartyEmailAddress", ModelService.IN_PARAM, context);
            serviceCtx.put("contactMechId", (String) context.get("emailContactMechId"));
            result = dispatcher.runSync("updatePartyEmailAddress", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();
            serviceCtx = dctx.makeValidContext("updatePartyTelecomNumber", ModelService.IN_PARAM, context);
            serviceCtx.put("contactMechId", (String) context.get("phoneContactMechId"));
            result = dispatcher.runSync("updatePartyTelecomNumber", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();
        } catch (GenericServiceException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError(e.getMessage());
        }
        return ServiceUtil.returnSuccess();
    }

    public static Map<String, Object> trainingUpdateSupplierPostalAddress(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = new HashMap<>();
        LocalDispatcher dispatcher = dctx.getDispatcher();
        try {
            Map<String, Object> serviceCtx = dctx.makeValidContext("updatePartyPostalAddress", ModelService.IN_PARAM, context);

            result = dispatcher.runSync("updatePartyPostalAddress", serviceCtx);
            if (ServiceUtil.isError(result)) {
                Debug.logError(ServiceUtil.getErrorMessage(result), MODULE);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(result));
            }
            serviceCtx.clear();
        } catch (GenericServiceException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError(e.getMessage());
        }
        return ServiceUtil.returnSuccess();
    }
}