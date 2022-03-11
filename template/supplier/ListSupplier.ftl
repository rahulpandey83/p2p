<div class="screenlet-body">


    <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>${uiLabelMap.GroupName}</th>
            <th>${uiLabelMap.Phone}</th>
            <th>${uiLabelMap.Email}</th>
            <th>${uiLabelMap.Address}</th>

        </tr>
        </thead>
        <tbody>
        <#if supplierList?has_content>
        <#list supplierList as supplierList>

        <tr>
            <td>${supplierList.groupName!}</td>
            <td>${supplierList.tnContactNumber!}</td>
            <td>${supplierList.infoString!}</td>
            <td>
                ${supplierList.paAddress1!},${supplierList.paAddress2!},${supplierList.paCity!},${supplierList.paStateProvinceGeoId!},${supplierList.paPostalCode!},${supplierList.paCountryGeoId!}
            </td>

        </tr>
        </#list>
        </tbody>
    </table>
</#if>
</div>