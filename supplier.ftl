<div class="screenlet">
    <form id="createSupplierEvent" method="post" action="<@ofbizUrl>createSupplierEvent</@ofbizUrl>">
        <input type="hidden" name="createSupplierEvent" value="Y"/>
        <fieldset>
            <div>
                <span class="label">${uiLabelMap.GroupName}</span>
                <input type="text" name="groupName" id="groupName" class='required' maxlength="20"/>*
            </div>
            <div>
                <span class="label">${uiLabelMap.Phone}</span>
                <tr>
                    <td>
                        <input type="text" size="4" maxlength="10" name="countryCode"
                               value="${(mechMap.telecomNumber.countryCode)?default(request.getParameter('countryCode')!)}"/>
                        -&nbsp;<input type="text" size="4" maxlength="10" name="areaCode"
                                      value="${(mechMap.telecomNumber.areaCode)?default(request.getParameter('areaCode')!)}"/>
                        -&nbsp;<input type="text" size="15" maxlength="15" name="contactNumber"
                                      value="${(mechMap.telecomNumber.contactNumber)?default(request.getParameter('contactNumber')!)}"/>
                        &nbsp;${uiLabelMap.PartyContactExt}&nbsp;<input type="text" size="6" maxlength="10"
                                                                        name="extension"
                                                                        value="${(mechMap.partyContactMech.extension)?default(request.getParameter('extension')!)}"/>
                    </td>
                </tr>
            </div>
            <tr>
                <div>
                    <span class="label">${uiLabelMap.Email}</span>
                    <input type="text" name="Email" id="Email" class='' maxlength="100"/>
                </div>
                <div>
                    <span class="label">${uiLabelMap.Address1}</span>
                    <input type="text" name="Address1" id="Address1" class='' maxlength="200"/>*
                </div>
                <div>
                    <span class="label">${uiLabelMap.Address2}</span>
                    <input type="text" name="Address2" id="Address2" class='' maxlength="200"/>
                </div>
                <div>
                    <span class="label">${uiLabelMap.City}</span>*
                    <input type="text" name="City" id="City" class='' maxlength="20"/>
                </div>
                <div>
                    <span class="label">${uiLabelMap.PostalCode}</span>*
                    <input type="text" name="postalCode" id="postalCode" class='' maxlength="20"/>
                </div>
                <div>
                    <span class="label">${uiLabelMap.State}</span>
                    <td>
                        <select name="stateProvinceGeoId" id="editcontactmechform_stateProvinceGeoId">
                        </select>
                    </td>
                    <input type="text" name="stateProvinceGeoId" id="State" maxlength="20"/>
                </div>
                <div>
                    <span class="label">${uiLabelMap.Country}</span>
            <tr>
                <td>
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
                </td>
            </tr>
</div>
</fieldset>
<input type="submit" value="${uiLabelMap.CommonAdd}"/>
</form>
</div>
