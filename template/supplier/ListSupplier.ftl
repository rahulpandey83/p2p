<#if supplierList?has_content>
  <table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>
      <th>${uiLabelMap.PartyId}</th>
      <th>${uiLabelMap.SupplierName}</th>
      <th>${uiLabelMap.Phone}</th>
      <th>${uiLabelMap.Email}</th>
      <th>${uiLabelMap.Address}</th>
    </tr>
    </thead>
    <tbody>
    <#list supplierList as supplierInfo>
      <tr>
        <td><a href="<@ofbizUrl>ViewProfile</@ofbizUrl>?partyId=${supplierInfo.partyId!}">${supplierInfo.partyId!}</a></td>
        <td> ${supplierInfo.groupName!"-"}</td>
        <td> ${supplierInfo.contactNumber!"-"}</td>
        <td> ${supplierInfo.infoString!"-"}</td>
          <#if supplierInfo.address1?has_content>
            <td> ${supplierInfo.address1!"-"},
                 ${supplierInfo.address2!"-"},
                 ${supplierInfo.city!"-"},
                 ${supplierInfo.postalCode!"-"},
                 ${supplierInfo.stateGeoName!"-"},
                 ${supplierInfo.countryGeoName!"-"}
            </td>
          <#else>
            <td>-</td>
          </#if>
        </tr>
      </#list>
    </tbody>
  </table>
<#else>
 <label>not found</label>
</#if>
