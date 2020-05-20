<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-danger">Sign Out</button>
    </form>

<form action="/order/create" method="post">
<#list pizzas as pizza>
    <div class="form-group">
        <input class="form-check-input" type="checkbox" name="pizzas" value="${pizza.id}">
        <label>${pizza.title}</label>
        <label>Price: ${pizza.price}</label>
        <label>Diameter: ${pizza.diameter}</label>
    </div>
</#list>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <label>Address:</label>
    <input type="text" name="address" class="form-control" placeholder="Address">
    <button type="submit" class="btn btn-success">Make Order</button>
</form>

</@c.page>