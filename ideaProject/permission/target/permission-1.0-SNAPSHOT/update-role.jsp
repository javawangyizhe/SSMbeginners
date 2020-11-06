<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>办公系统 - 基础表格</title>
    <meta name="keywords" content="办公系统">
    <meta name="description" content="办公系统">

    <link rel="shortcut icon" href="favicon.ico"> 
    	<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
	<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
      <div class="row">
            <div >
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>编辑角色</h5>
                    </div>
                    <div class="ibox-content">
                        <form id="updateRoleForm" class="form-horizontal">
                            <input type="hidden" name="roleid" value="${param.roleid}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色名称：</label>

                                <div class="col-sm-8">
                                    <input type="text" name="rolename" id="rolename" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色描述：</label>

                                <div class="col-sm-8">
                                    <input type="text" name="roledis" id="roledis" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色权限：</label>
                                <div class="col-sm-8">
                                    <ul id="treeDemo" class="ztree"></ul>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否启用：</label>
                                <input type="radio" name="status" id="status1" value="1">启用
                                <input type="radio" name="status" id="status2" value="0">禁用
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button id="saveRole" class="btn btn-sm btn-white" type="button"><i class="fa fa-save"></i> 保存</button>
                                    <button class="btn btn-sm btn-white" type="reset"><i class="fa fa-undo"></i> 重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
      </div>
    </div>

 
    
    
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="js/plugins/select/bootstrap-select.min.js"></script>
	<script src="js/plugins/layer/laydate/laydate.js"></script>
    <script src="js/plugins/ztree/jquery.ztree.all-3.5.min.js"></script>
    <link rel="stylesheet" href="css/plugins/zTreeStyle/zTreeStyle.css" />
   <!-- 修复日期控件长度-->
   <link href="css/customer.css" rel="stylesheet">
<script>
    var setting = {
        data: {
            simpleData: {
                enable: true,
                pIdKey:"pid"
            }
        },
        check: {
            enable: true
        }
    };
    var zTreeObj;

    //初始化树
    $(function(){
        $.ajax({
            url:"loadRoleInfo",
            type:"POST",
            data: {"roleid":${param.roleid}},
            dataType: "json",
            success:function (map){
                $("#rolename").val(map.role.rolename);
                $("#roledis").val(map.role.roledis);
                if(map.role.status==1){
                    $("#status1").prop("checked","checked");
                }else{
                    $("#status2").prop("checked","checked");
                };
                loadResource();
                function loadResource(){
                    $.ajax({
                        url:"findAllSources",
                        type:"GET",
                        dataType:"json",
                        success:function(obj){
                            zTreeObj=$.fn.zTree.init($("#treeDemo"), setting, obj);
                            zTreeObj.expandAll(true);
                            $.each(map.roleSources,function (index,item) {
                                var sid = item.resourcesFk;
                                var nodes = zTreeObj.getNodeByParam("id", sid, null);
                                zTreeObj.checkNode(nodes, true, false);
                            })
                        }
                    });
                }
            }
        });

    })

    /**
     * 保存按钮
     */
    $("#saveRole").click(function(){
        var serialize = $("#updateRoleForm").serialize();
        var nodes = zTreeObj.getCheckedNodes(true);
        if(nodes.length == 0){
            swal("请您选择角色权限");
            return ;
        }
        var arr=[];
        for(var i = 0;i<nodes.length;i++){
            var node = nodes[i];
            arr[i]=node.id;
        }
        var sid = arr.toString();
        window.location.href = "${pageContext.request.contextPath}/updateRole?sid="+sid+"&"+serialize;
    })

</script>
</body>


</html>