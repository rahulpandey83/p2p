<div class="screenlet-body" xmlns="http://www.w3.org/1999/html">
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.Profile}
    </div>
    <div class="panel-body">
      <#if supplierList?has_content>
        <#list supplierList as supplierList>
          <dl class="dl-horizontal col-sm-4">
            <dt>${uiLabelMap.PartyId} -</dt>
            <dd>${supplierList.partyId!"-"}</dd>
            <dt>${uiLabelMap.SupplierName} -</dt>
            <dd>${supplierList.groupName!"-"}</dd>
            <dt>${uiLabelMap.Phone} -</dt>
            <dd>${supplierList.contactNumber!"-"}</dd>
            <dt>${uiLabelMap.CommonEmail} -</dt>
            <dd>${supplierList.infoString!"-"}</dd>
          </dl>
          <span class="pull-left"><a class="btn  btn-primary p3" href="<@ofbizUrl>EditProfile</@ofbizUrl>?partyId=${supplierList.partyId!}">Edit</a></span>
        </#list>
      </#if>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.Address}</div>
    <div class="panel-body">
      <#if supplierList?has_content>
        <#list supplierList as supplierList>
          <dl class="dl-horizontal col-sm-4">
            <dt>${uiLabelMap.CommonAddress1} -</dt>
            <dd>${supplierList.address1!"-"}</dd>
            <dt>${uiLabelMap.CommonAddress2} -</dt>
            <dd>${supplierList.address2!"-"}</dd>
            <dt>${uiLabelMap.CommonCity} -</dt>
            <dd>${supplierList.city!"-"}</dd>
            <dt>${uiLabelMap.CommonZipPostalCode} -</dt>
            <dd>${supplierList.postalCode!"-"}</dd>
            <dt>${uiLabelMap.CommonState} -</dt>
            <dd>${supplierList.stateGeoName!"-"}</dd>
            <dt>${uiLabelMap.CommonCountry} -</dt>
            <dd>${supplierList.countryGeoName!"-"}</dd>
          </dl>
          <span class=""><a class="btn  btn-primary p3" href="<@ofbizUrl>EditAddress</@ofbizUrl>?partyId=${supplierList.partyId!}">Edit</a></span>
        </#list>
      </#if>
    </div>
  </div>
</div>
