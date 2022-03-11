<div class="screenlet-body">

    <form id="FindSupplier" method="post" action="<@ofbizUrl>FindSupplier</@ofbizUrl>" class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="groupName">${uiLabelMap.GroupName}</label>
            <div class="controls">
                <input type="text" name="groupName" id="groupName" class='required' maxlength="20"/>*
            </div>
        </div>

        <br>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn">${uiLabelMap.CommonFind}</button>
            </div>
        </div>
    </form>
</div>