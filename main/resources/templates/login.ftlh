<#import "parts/common.ftlh" as c>

<@c.page>
Login page
<form action="/login" method="post">
    <div class="form-group">
        <label>Email</label>
        <input class="form-control" aria-describedby="emailHelp" type="text" placeholder="Enter email" name="username"/>
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit" class="btn btn-primary">Sign In</button>
</form>

<a class="btn btn-primary" href="/users/create" role="button">Add new User</a>
</@c.page>