<!DOCTYPE html>
<html lang="zh-cn" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Paginationjs example</title>

    <script src="js/bootstrap.min.js"></script>

    <link href="css/pagination.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<#include "/header.ftl">
<div id="wrapper">
    <section>
<div class="data-container"></div>
<div id="pagination-demo1"></div>
</section>
</div>

<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<script src="js/pagination.js"></script>
<script>
    $(function () {
        function createDemo(name) {
            var container = $('#pagination-' + name);
            var sources = function () {
                var result = [];

                for (var i = 1; i < 196; i++) {
                    result.push(i);
                }

                return result;
            }();

            var options = {
                dataSource: sources,
                callback: function (response, pagination) {
                    window.console && console.log(response, pagination);

                    var dataHtml = '<ul>';

                    $.each(response, function (index, item) {
                        dataHtml += '<li>' + item + '</li>';
                    });

                    dataHtml += '</ul>';

                    container.prev().html(dataHtml);
                }
            };

            //$.pagination(container, options);

            container.addHook('beforeInit', function () {
                window.console && console.log('beforeInit...');
            });
            container.pagination(options);

            container.addHook('beforePageOnClick', function () {
                window.console && console.log('beforePageOnClick...');
                //return false
            });

            return container;
        }

        createDemo('demo1');
    });
</script>
</body>
</html>
