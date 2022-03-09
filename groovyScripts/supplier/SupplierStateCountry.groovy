import org.apache.ofbiz.entity.condition.EntityCondition

cond = EntityCondition.makeCondition("geoTypeId", "COUNTRY");
countries = from("Geo").where(cond).queryList();
context.countries=countries;

cond = EntityCondition.makeCondition("geoTypeId", "STATE");
states = from("Geo").where(cond).queryList();
context.states = states;
