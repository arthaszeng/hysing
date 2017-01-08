<!DOCTYPE html>
<html lang="zh-cn" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hysing</title>

    <script src="/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <![endif]-->
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <#include "/header.ftl">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h3>
                        </br>
                        </br>
                        Candidate List
                    </h3>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Nickname</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Contribution</th>
                            <th>Joined Time</th>
                            <th>Stars</th>
                            <th>Followers</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list candidateList as candidate>
                        <tr>
                            <td>${candidate.nickname!"N/A"}</td>
                            <td>${candidate.name!"N/A"}</td>
                            <td>${candidate.email!"N/A"}</td>
                            <td>${candidate.contribution!"N/A"}</td>
                            <td>${candidate.joinedTime!"N/A"}</td>
                            <td>${candidate.starNumber!"N/A"}</td>
                            <td>${candidate.followerNumber!"N/A"}</td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">©2016 Contributed By Arthas Zeng, cwzeng@thoughtworks.com</p>
    </div>
</footer>
</body>
</html>


