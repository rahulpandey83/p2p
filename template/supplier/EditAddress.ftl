<div class="screenlet-body" xmlns="http://www.w3.org/1999/html">
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.EditAddress}</div>
    <div class="panel-body">
      <#if supplierInfo.supplierAddressInfo?has_content>
      <#assign supplierAddressInfo = supplierInfo.supplierAddressInfo/>
        <form id="updateSupplierPostalAddress" method="post" action="<@ofbizUrl>updateSupplierPostalAddress</@ofbizUrl>" class="form-horizontal">
          <input type="hidden" id="partyId" name="partyId" value=${supplierAddressInfo.partyId!}>
          <div class="form-group row">
            <label for="address1" class="col-sm-1 col-form-label">${uiLabelMap.CommonAddress1}</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="address1" name="address1" value="${supplierAddressInfo.address1!}">
              <input type="hidden" id="contactMechId" name="contactMechId" value=${supplierAddressInfo.addressContactId!}>
            </div>
          </div>
          <div class="form-group row">
            <label for="address2" class="col-sm-1 col-form-label">${uiLabelMap.CommonAddress2}</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="address2" name="address2" value="${supplierAddressInfo.address2!}">
            </div>
          </div>
          <div class="form-group row">
            <label for="city" class="col-sm-1 col-form-label">${uiLabelMap.CommonCity}</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="city" name="city" value="${supplierAddressInfo.city!}">
            </div>
          </div>
          <div class="form-group row">
            <label for="postalCode" class="col-sm-1 col-form-label">${uiLabelMap.CommonZipPostalCode}</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="postalCode" name="postalCode" value="${supplierAddressInfo.postalCode!}">
            </div>
          </div>
          <div class="form-group row">
            <label for="stateProvinceGeoId" class="col-sm-1 col-form-label">${uiLabelMap.CommonState}</label>
            <div class="col-sm-6">
              <select  class="col-sm-12" id="stateProvinceGeoId" name="stateProvinceGeoId">
                <#list states as state>
                  <option value='${state.geoId}'>${state.geoName}</option>
                </#list>
              </select>
            </div>
          </div>
          <div class="form-group row">
            <label for="countryGeoId" class="col-sm-1 col-form-label">${uiLabelMap.CommonCountry}</label>
            <div class="col-sm-6">
              <select  class="col-sm-12 " id="countryGeoId" name="countryGeoId">
                <#list countries as country>
                  <option  value='${country.geoId}'>${country.geoName}</option>
                </#list>
              </select>
            </div>
          </div>
          <div class="form-group row ">
            <div class="col-sm-6 pull-right">
              <button type="submit" class="btn btn-primary">${uiLabelMap.CommonUpdate}</button>
            </div>
          </div>
        </form>
      </#if>
    </div>
  </div>
</div>
