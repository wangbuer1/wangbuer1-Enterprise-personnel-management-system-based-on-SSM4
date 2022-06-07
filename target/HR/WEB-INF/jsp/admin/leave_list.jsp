<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.hebeu.entity.*" %>
<%@ page import="com.baomidou.mybatisplus.plugins.Page" %>
<%@page import="edu.hebeu.util.MTimeUtil"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>企业人事管理 - 员工请假列表</title>
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="shortcut icon" href="favicon.ico">
	<link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

	<!-- Data Tables -->
	<link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css"
		rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/dist/sweetalert.css">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>请假列表</h5>
					</div>
					<div class="ibox-content">
						<table class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>序号</th>
									<th>姓名</th>
									<th>开始日期</th>
									<th>结束日期</th>
									<th>天数</th>
									<th>类型</th>
									<th>请假原因</th>
									<th>审批状态</th>
								</tr>
							</thead>
							<tbody>
							<%
                            	List<Leave> list = (List<Leave>)request.getAttribute("list");
                            	int index=1;
                            	for(Leave leave : list){
                            %>
								<tr class="gradeA">
									<td><%=index++ %></td>
									<td><%=leave.getEmployee().getName() %></td>
								<%
									String starttime = MTimeUtil.dateFormat(leave.getStartTime());
									String endtime = MTimeUtil.dateFormat(leave.getStartTime());
								%>
									<td><%=starttime %></td>
									<td><%=endtime %></td>
									<td><%=leave.getDays() %></td>
									<td><%=leave.getType() %></td>
									<td><%=leave.getReason() %></td>
									<td><%=leave.getStatus() %></td>
								</tr>
							<%
                           		 }
                             %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 全局js -->
	<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- 自定义js -->
	<script src="<%=path %>/js/content.js?v=1.0.0"></script>

 	<!-- layer javascript -->
    <script src="js/plugins/layer/layer.min.js"></script>
    <script>
       $(document).ready(function () {
           $('.dataTables-example').dataTable();
           
           var oTable = $('#editable').dataTable();
           
           oTable.$('td').editable('../example_ajax.php', {
               "callback": function (sValue, y) {
                   var aPos = oTable.fnGetPosition(this);
                   oTable.fnUpdate(sValue, aPos[0], aPos[1]);
               },
               "submitdata": function (value, settings) {
                   return {
                       "row_id": this.parentNode.getAttribute('id'),
                       "column": oTable.fnGetPosition(this)[2]
                   };
               },
               "width": "90%",
               "height": "100%"
           });
       });
    </script>
</body>
</html>
