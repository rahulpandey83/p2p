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
                <label class="control-label" for="address2">${uiLabelMap.Address1}</label>
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
                    <select name="stateProvinceGeoId">
                        <#if currentStateGeo?has_content>
                        <option value="${currentStateGeo.geoId}">${currentStateGeo.geoName?default(currentStateGeo.geoId)}</option>
                        <option value="${currentStateGeo.geoId}">---</option>
                    </#if>
                    <option value="ANY">${uiLabelMap.CommonAnyStateProvince}</option>
                    ${screens.render("component://common/widget/CommonScreens.xml#states")}
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="countryGeoId">${uiLabelMap.Country}</label>
                <div class="controls">
                    <select name="countryGeoId" id="editcontactmechform_countryGeoId">
                        ${screens.render("component://common/widget/CommonScreens.xml#countries")}
                        <#if (mechMap.postalAddress??) && (mechMap.postalAddress.countryGeoId??)>
                        <#assign defaultCountryGeoId = mechMap.postalAddress.countryGeoId>
                        <#else>
                        <#assign defaultCountryGeoId =
                        Static["org.apache.ofbiz.entity.util.EntityUtilProperties"].getPropertyValue("general",
                        "country.geo.id.default", delegator)>
                    </#if>
                    <option selected="selected" value="${defaultCountryGeoId}">
                        <#assign countryGeo =
                        delegator.findOne("Geo",Static["org.apache.ofbiz.base.util.UtilMisc"].toMap("geoId",defaultCountryGeoId),
                        false)>
                        ${countryGeo.get("geoName",locale)}
                    </option>
                    </select>
                </div>
            </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn">${uiLabelMap.CommonAdd}</button>
            </div>
        </div>
    </form>
</div>
