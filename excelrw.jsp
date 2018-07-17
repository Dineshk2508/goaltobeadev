<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>List users</title>
        <link href="https://www.w3schools.com/w3css/4/w3.css" rel="stylesheet" />
        <link href="style.css" rel="stylesheet" />
        <script type="text/javascript" src="pager.js"></script>
        <style type="text/css">
            .pg-normal {
            	align:center;
                color: black;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                font-family:    'Lucida Grande',Verdana,Arial,Sans-Serif;
                font-size:13px
            }
            .pg-selected {
            	align:center;
                color: black;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                font-family:    'Lucida Grande',Verdana,Arial,Sans-Serif;
                font-size:13px
            }
        </style>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('#mytable').each(function() {
                	$("tr:even").css("background-color", "#ffcccc");
                	$("tr:odd").css("background-color", "#ffe6e6");
                });
            });
        </script>
    </head>

    <body>
        <h1> List </h1>
        <hr/>
        <form name="check" action="process" method="POST">
            <input type="submit" name="Getvalue" id="getvalue" value="Get Value" />
            <table id="mytable">
                <thead>
                    <tr>
                        <th>Select</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Gender</th>
                        <th>Age</th>
                        <th>City</th>
                        <th>Country</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="templist" items="${dlist}">
                        <tr>
                            <td>
                                <input type="checkbox" id="Selection" name="Selection" value="${templist.rowno}">
                            </td>
                            <td>
                                <input type="textbox" id="firstName" name="firstName" value="${templist.firstName}" />
                            </td>
                            <td>
                                <input type="textbox" id="lastName" name="lastName" value="${templist.lastName}" />
                            </td>
                            <td>
                                <input type="textbox" id="gender" name="gender" value="${templist.gender}" />
                            </td>
                            <td>
                                <input type="textbox" id="age" name="age" value="${templist.age}" />
                            </td>
                            <td>
                                <input type="textbox" id="city" name="city" value="${templist.city}" />
                            </td>
                            <td>
                                <input type="textbox" id="country" name="country" value="${templist.country}" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div id="pageNavPosition"></div>
        </form>

        <script type="text/javascript">
            var pager = new Pager('mytable', 20);
            pager.init();
            pager.showPageNav('pager', 'pageNavPosition');
            pager.showPage(1);
        </script>

        </div>
        </form>
    </body>

    </html>