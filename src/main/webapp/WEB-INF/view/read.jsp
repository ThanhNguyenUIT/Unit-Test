<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <script>
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/RESTful/rest/student/',
                data: {get_param: 'value'},
                dataType: 'json',
                success: function (data) {
                    $.each(data, function (index, element) {
                        $('body').append($('<div>', {
                            text: element.firstName + ", " + element.lastName + ", " + element.birthDay + ", " + element.email
                        }));
                    });
                }
            });
        });
    </script>
</head>
<body>
</body>
</html>