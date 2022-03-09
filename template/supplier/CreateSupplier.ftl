<div class="screenlet-body">
  <form id="createSupplier" method="post" action="<@ofbizUrl>createSupplier</@ofbizUrl>" class="form-horizontal">
    <div class="control-group">
      <label class="control-label" for="groupName">${uiLabelMap.GroupName}</label>
        <div class="controls">
          <input type="text" name="groupName" id="groupName" class='required' maxlength="20"/>*
        </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="contactNumber">${uiLabelMap.Phone}</label>
        <div class="controls">
          <input type="text" name="contactNumber" id="contactNumber" class='required' maxlength="20"/>*
        </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="email">${uiLabelMap.Email}</label>
        <div class="controls">
          <input type="text" name="email" id="email" class='required' maxlength="20"/>*
        </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="address1">${uiLabelMap.Address1}</label>
        <div class="controls">
          <input type="text" name="address1" id="address1" class='required' maxlength="200"/>*
        </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="address2">${uiLabelMap.Address2}</label>
        <div class="controls">
          <input type="text" name="address2" id="address2" class='required' maxlength="200"/>*
        </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="city">${uiLabelMap.City}</label>
        <div class="controls">
          <input type="text" name="city" id="city" class='required' maxlength="20"/>*
        </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="city">${uiLabelMap.PostalCode}</label>
        <div class="controls">
          <input type="text" name="postalCode" id="postalCode" class='required' maxlength="20"/>*
        </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="stateProvinceGeoId">${uiLabelMap.State}</label>
        <div class="controls">
          <select id="stateProvinceGeoId" name="stateProvinceGeoId">
            <#list states as stateType>
              <option value='${stateType.geoId}'>${stateType.geoName}</option>
            </#list>
          </select>
    </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="countryGeoId">${uiLabelMap.Country}</label>
        <div class="controls">
          <select id="countryGeoId" name="countryGeoId">
            <#list countries as countryType>
              <option value='${countryType.geoId}'>${countryType.geoName}</option>
            </#list>
          </select>
        </div>
    </div>
    <br>
    <div class="control-group">
      <div class="controls">
        <button type="submit" class="btn">${uiLabelMap.CommonAdd}</button>
      </div>
    </div>
  </form>
</div>
