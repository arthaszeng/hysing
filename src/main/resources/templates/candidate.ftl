<!DOCTYPE html>
<html lang="zh-cn" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hysing</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"><span class="sr-only">Toggle navigation</span><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="/">Hysing</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/">Dashboard</a>
                        </li>
                        <li class="active">
                            <a href="/candidate">Candidates</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Spider Control<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Overview</a>
                                </li>
                                <li>
                                    <a href="#">Dashboard</a>
                                </li>
                                <li>
                                    <a href="#">Terminal</a>
                                </li>
                                <li class="divider">
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control"/>
                        </div>
                        <button type="submit" class="btn btn-default">Search</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">Login</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">MyProfile<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
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
                    <ul class="pagination pagination-sm" style="float: right">
                        <li><a href="#">Prev</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
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
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
</body>
<div></div>
</html>

