<#import "parts/common.ftlh" as c>

<@c.page>
Registration page

    <form action="/users" method="post">
        <div class="form-group">
            <label>Email</label>
            <input class="form-control" aria-describedby="emailHelp" type="text" placeholder="Enter email" name="username"/>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Sign Up</button>
    </form>
</@c.page>