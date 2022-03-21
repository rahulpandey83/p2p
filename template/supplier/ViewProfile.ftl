<div class="screenlet-body" xmlns="http://www.w3.org/1999/html">
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.Profile}</div>
    <div class="panel-body">
      <#if supplierInfo?has_content>
        <#assign supplierInfo = supplierInfo/>
          <dl class="dl-horizontal col-sm-4">
            <dt>${uiLabelMap.PartyId} -</dt>
            <dd>${supplierInfo.partyId!}</dd>
            <dt>${uiLabelMap.SupplierName} -</dt>
            <dd>${supplierInfo.groupName!}</dd>
            <dt>${uiLabelMap.Phone} -</dt>
            <dd>${supplierInfo.contactNumber!}</dd>
            <dt>${uiLabelMap.CommonEmail} -</dt>
            <dd>${supplierInfo.infoString!}</dd>
          </dl>
          <span class="pull-left"><a class="btn  btn-primary p3" href="<@ofbizUrl>UpdateSupplierDetail</@ofbizUrl>?partyId=${supplierInfo.partyId!}">Edit</a></span>
      </#if>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.Address}</div>
    <div class="panel-body">
      <#if supplierInfo?has_content>
      <#assign supplierAddressInfo = supplierInfo.supplierAddressInfo/>
        <dl class="dl-horizontal col-sm-4">
          <#if supplierAddressInfo.address1?has_content>
            <dt>${uiLabelMap.CommonAddress1} -</dt>
            <dd>${supplierAddressInfo.address1!}</dd>
            <dt>${uiLabelMap.CommonAddress2} -</dt>
            <dd>${supplierAddressInfo.address2!}</dd>
            <dt>${uiLabelMap.CommonCity} -</dt>
            <dd>${supplierAddressInfo.city!}</dd>
            <dt>${uiLabelMap.CommonZipPostalCode} -</dt>
            <dd>${supplierAddressInfo.postalCode!}</dd>
            <dt>${uiLabelMap.CommonState} -</dt>
            <dd>${supplierAddressInfo.stateGeoName!}</dd>
            <dt>${uiLabelMap.CommonCountry} -</dt>
            <dd>${supplierAddressInfo.countryGeoName!}</dd>
          <#else>
            <dt>${uiLabelMap.CommonAddress1} -</dt>
            <dt>${uiLabelMap.CommonAddress2} -</dt>
            <dt>${uiLabelMap.CommonCity} -</dt>
            <dt>${uiLabelMap.CommonZipPostalCode} -</dt>
            <dt>${uiLabelMap.CommonState} -</dt>
            <dt>${uiLabelMap.CommonCountry} -</dt>
          </#if>
        </dl>
        <span class=""><a class="btn  btn-primary p3" href="<@ofbizUrl>UpdateSupplierPostalAddress</@ofbizUrl>?partyId=${supplierInfo.partyId!}">Edit</a></span>
      </#if>
    </div>
  </div>
</div>
