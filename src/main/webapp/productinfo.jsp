<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic CRUD Application - jQuery EasyUI CRUD Demo</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div align="center">
    <h2>商品信息维护</h2>

    <table id="dg" title="商品信息" class="easyui-datagrid" style="width:1250px;height:450px"
           url="selectProduct"
           toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true">
    </table>
    <!--工具栏-->
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
           onclick="newUser()">新增商品</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑商品</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
           onclick="destroyUser()">删除商品</a>
    </div>

    <div id="dlg" class="easyui-dialog" style="width:400px"
         data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>product Information</h3>

            <div style="margin-bottom:10px">
                <input name="productName" class="easyui-textbox" required="true" label="商品名称:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="productPrice" class="easyui-textbox" required="true" label="商家价格:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="productStock" class="easyui-textbox" required="true" label="商品存量:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="productDescription" class="easyui-textbox" required="true" label="商品介绍:"
                       style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="productIcon" class="easyui-textbox" required="true" label="图片链接:" style="width:100%">
            </div>

            <div style="margin-bottom:10px">

                    <span>商品类目：</span>
                    <select name="categoryType" id="type" style="width: 216px;height: 28px;border-radius: 5px 5px 5px 5px; position: absolute;left: 130px">
                        <option value="0">类别</option>
                    </select>
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()"
           style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    Copyright © 2010-2019 yanliming
</div>
<script type="text/javascript">
    var url;
    //jquery初始化函数
    $(function(){
        //选择datagrid
        $('#dg').datagrid({
            title:"商品信息",
            url:"selectProduct",
            width:1250,
            columns:[[
                {field:'productId',title:'商品编号',width:50},
                {field:'productName',title:'商品名称',width:50},
                {field:'productPrice',title:'商家价格',width:50},
                {field:'productStock',title:'商品存量',width:50},
                {field:'productDescription',title:'商品介绍',width:120},
                {field:'productIcon',title:'图片链接',width:50},
                {field:'状态',title:'状态',width:40,
                    formatter:function(value, row, index){

                        var str = '<a  id="proStatus" style="color:blue" href="#"  class="easyui-linkbutton" onclick="productStatus(\''+row.productId+'\')">'+row.productStatus+'</a>';


                        return str;
                    }},
                {field:'categoryType',title:'商品类别',width:40},
                {field:'createTime',title:'创建时间',width:120},
                {field:'updateTime',title:'更新时间',width:120}
            ]]
        });
    });

    function productStatus(productId){
        $.ajax({
            type: "post",
            dataType: "html",
            url: 'updateStatus',
            data: {"productId":productId},
            success: function (data) {       //服务器返回值
                var data = eval('('+data+')');//转换为json对象
                $('#dg').datagrid('reload');// reload the user data
            }
        });

    }
    function newUser() {
        $('#dlg').dialog('open').dialog('center').dialog('setTitle', '添加商品信息');
        $('#fm').form('clear');
        url = 'insertProduct';

        $('#type').html("");
        $.ajax({
            url:"selectAllCate",
            type:"get",
            success:function(result){
                var str = "";
                for (var i = 0; i < result.length; i++) {
                    str = str + "<option value='" + result[i].categoryId + "'>" + result[i].categoryName + "</option>";
                }
                $('#type').html($('#type').html()+str);//
            }
        });
    }

    function editUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'Edit User');
            $('#fm').form('load', row);
            url = 'updateProduct?productId=' + row.productId;

            $('#type').html("");
            $.ajax({
                url:"selectAllCate",
                type:"get",
                success:function(result){
                    var str = "";
                    for (var i = 0; i < result.length; i++) {
                        str = str + "<option value='" + result[i].categoryId + "'>" + result[i].categoryName + "</option>";
                    }
                    $('#type').html($('#type').html()+str);
                }
            });
        }
    }

    function saveUser() {
        $('#fm').form('submit', {
            url: url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (result) {
                var result = eval('(' + result + ')');
                if (result.errorMsg) {
                    $.messager.show({
                        title: 'Error',
                        msg: result.errorMsg
                    });
                } else {
                    $('#dlg').dialog('close');        // close the dialog
                    $('#dg').datagrid('reload');    // reload the user data
                }
            }
        });
    }

    function destroyUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', '您确认要删除此商品信息吗?', function (r) {
                if (r) {
                    $.post('delProduct', {productId: row.productId}, function (result) {
                        if (result.success) {
                            $('#dg').datagrid('reload');    // reload the user data
                        } else {
                            $.messager.show({    // show error message
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        }
                    }, 'json');
                }
            });
        }
    }

</script>


</body>
</html>
﻿
