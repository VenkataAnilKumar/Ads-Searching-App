<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ads Searching System</title>
    <script type="text/javascript" src="resources/angular-1.5.7/angular.js"></script>
    <script type="text/javascript" src="resources/angular-1.5.7/angular.min.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/css/theme.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">


</head>
<body ng-app= "myApp">
<div ng-controller="myCtrl">
    <div class="container">
        <div class="header clearfix">
            <nav>
                <ul class="nav nav-pills pull-right">
                    <li role="presentation" ><a href="index.jsp">Home</a></li>
                    <li role="presentation" class="active"><a href="#">About</a></li>
                    <%--<li role="presentation"><a href="contact.jsp">Contact</a></li>--%>
                </ul>
            </nav>
            <h3 class="text-muted" align="left">Ads Searching System</h3>
        </div>


        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Description</h3>
            </div>
            <div class="panel-body">
                The Ads searching system is an ads platform to rank and display ads for users.
            </div>
        </div>
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Motivation</h3>
            </div>
            <div class="panel-body">
                By calculating the relativity between the user's query and the ads provided by merchants, this ads searching system displays the most relevant ads that users are most interested in so that user are more likely to click the ads.<br>
                In the meantime, merchants can easily target the most potential customers and put the right ads with the lowest cost.
            </div>
        </div>

        <div class="alert alert-self" role="alert">
            <strong><img src="webapp/img/github.io" alt="Github"></strong> <a href ="https://github.com/ec500-software-engineering/project-02-e-commerce-search-advertising-system" >https://github.com/qzhizhou/Ads-Searching-System</a>
        </div>

        <footer class="footer">
            <p>@2019 Zhizhou Qiu, Qinmei Du</p>
        </footer>

    </div> <!-- /container -->
</div>
</body>
</html>
