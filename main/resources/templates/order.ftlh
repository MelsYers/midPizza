<#import "parts/common.ftlh" as c>

<@c.page>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit" class="btn btn-danger">Sign Out</button>
</form>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Address</th>
            <th scope="col">Order Price</th>
            <th scope="col">Time</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <td>${order.address}</td>
                <td>${order.orderPrice}</td>
                <td>${order.time}</td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>