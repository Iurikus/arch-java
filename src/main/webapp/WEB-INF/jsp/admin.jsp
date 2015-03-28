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
    <title>adminPage</title>
    <script src="jtable.2.4.0/jquery.jtable.js" />
    <script src="jquery-1.11.2.js"/>
    <script src="jquery-ui-1.11.4/jquery-ui.js"/>

    <script type="text/javascript">
        $(document).ready(function() {

                    $('tableContainer').jtable({
                        title : 'my custom title',
                        paging : true,
                        pagingSize : 5,
                        sorting : false,

                        actions : {
                            listAction : 'admin/list'
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
                                width: '40%',
                                type: 'date',
                                displayFormat: 'dd/mm/yy'
                            }

                        }



                    })

                }
        )

    </script>
</head>
<body>

<spring:message code="admin.title"/><br/>

<a href="#"><spring:message code="admin.income_log"/></a>

<div id="tableContainer"/>

</body>
</html>
