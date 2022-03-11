import org.apache.ofbiz.entity.condition.EntityCondition
import org.apache.ofbiz.entity.condition.EntityOperator

keywords = parameters.keywords;
searchConditions = [];
supplierConditions = [];
if (keywords) {
    searchConditions.add(EntityCondition.makeCondition("groupName", EntityOperator.LIKE, "%" + keywords + "%"));
    searchConditions.add(EntityCondition.makeCondition("partyId", EntityOperator.LIKE, "%" + keywords + "%"));
    EntityCondition cond = EntityCondition.makeCondition(searchConditions, EntityOperator.OR);
    supplierConditions.add(cond);

}

supplierConditions.add(EntityCondition.makeCondition("roleTypeIdTo", "SUPPLIER"));
supplierRelationships = from("PartyRelationshipAndDetail").where(supplierConditions).queryList();

supplierList = [];
supplierRelationships.each { supplierRelationship ->
    supplierInfo = [:];

    supplierInfo.groupName = supplierRelationship.groupName;
    supplierInfo.partyId = supplierRelationship.partyId;

    partyId = supplierRelationship.partyId;

    println("===========================================+++++++++++++++++" + partyId)

    supplierContactDetails = from("PartyContactDetailByPurpose").where("partyId", partyId, "contactMechPurposeTypeId", "PRIMARY_EMAIL").filterByDate().queryFirst();
    supplierInfo.infoString = supplierContactDetails?.infoString

    supplierContactDetails = from("PartyContactDetailByPurpose").where("partyId", partyId, "contactMechPurposeTypeId", "PRIMARY_PHONE").filterByDate().queryFirst();
    supplierInfo.contactNumber = supplierContactDetails?.contactNumber

    supplierContactDetails = from("PartyContactDetailByPurpose").where("partyId", partyId, "contactMechPurposeTypeId", "PRIMARY_LOCATION").filterByDate().queryFirst();
    supplierInfo.address1 = supplierContactDetails?.address1
    supplierInfo.address2 = supplierContactDetails?.address2
    supplierInfo.city = supplierContactDetails?.city
    supplierInfo.postalCode = supplierContactDetails?.postalCode
    supplierInfo.stateGeoName = supplierContactDetails?.stateGeoName
    supplierInfo.countryGeoName = supplierContactDetails?.countryGeoName

    supplierList.add(supplierInfo);

}
context.supplierList = supplierList;



