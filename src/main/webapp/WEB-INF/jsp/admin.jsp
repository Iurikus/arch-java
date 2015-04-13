<%--
  Created by IntelliJ IDEA.
  User: yuri
  Date: 22.03.2015
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="admin.title"/></title>
    <link href="/resources/js/jquery-ui-1.11.4/jquery-ui.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="/resources/js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-ui-1.11.4/jquery-ui.js"></script>
    <script type="text/javascript" src="/resources/js/jtable.2.3.1/jquery.jtable.js"></script>



    <script type="text/javascript">
        $(document).ready(function() {

                    $('#tableContainer').jtable({
                        jqueryuiTheme: true,
                        title : 'my custom title',
                        paging : true,
                        pagingSize : 5,
                        pageSizes: [2, 3, 5],
                        sorting : false,

                        actions : {
                            listAction : 'http://localhost:8080/admin/listall.json',
                            createAction : 'http://localhost:8080/admin/create.json'
                        },

                        fields: {
                            /*user_id: {
                                key: true,
                                create : false,
                                edit : false,
                                list : false
                            },*/
                            email: {
                                title: 'E-Mail',
                                width: '40%'
                            },

                            balance: {
                                title : 'Balance',
                                width: '20%'
                            },

                            date: {
                                title: 'Date',
                                width: '40%'

                            }

                        }



                    });

                    $('#tableContainer').jtable('load');

                }
        );



    </script>
</head>
<body>

<spring:message code="admin.title"/><br/>

<a href="#"><spring:message code="admin.income_log"/></a>

<div id="tableContainer"/>

</body>
</html>
