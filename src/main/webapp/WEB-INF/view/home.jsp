<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise 8</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-4 col-md-4" style="margin-top: 50px; padding-top: 20px; border: 1px solid #cccccc;">
            <form action="/upload" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="file" name="file">
                </div>
                <button type="submit" class="btn btn-default">Upload</button>
            </form>
            <form action="/read" method="get">
                <button type="submit" class="btn btn-default">Read Data</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>