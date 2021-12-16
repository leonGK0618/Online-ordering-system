1.logback使用步骤:
  /resources 目录下新建logback-spring.xml
  格局规则配置logback-spring.xml
  /resources 目录下新建application.yml
  配置项目环境和日志目录

2.springboot整合mybatis：
  （1）引入启动器（mysql，mybatis）
  （2）配置数据源
  （3）配置mybatis
  （4）实体类
  （5）mapper接口
  （6）测试
  
3.动态sql ：#{}和${}
#{}是一个占位符
${}是纯粹的字符串的替换

4.mybatis返回自增主键
    @Insert("insert into sys_user(username,password,nickname,head_img_url,phone,telephone,email,birthday,sex,status,intro,create_time,update_time)"+
            "values(#{username},#{password},#{nickname},#{headImgUrl},#{phone},#{telephone},#{email},#{birthday},#{sex},#{status},#{intro},now(),now())")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveUser(SysUser user);
    System.out.println(sysUser.getId());//null
    userDao.saveUser(sysUser);
    System.out.println(sysUser.getId());//可以获取到主键

6.表头上的工具栏
 toolbar:'#barDemo',
   <script type="text/html" id="barDemo">
         <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
         <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
     </script>
    
    侧边工具栏
      ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
      
7.jquery选择器
  $("[name=roleId]:checked");选择所有name为roleId 被选中的
  
8.string不能转换成date
         @InitBinder
      public void initBinder(WebDataBinder binder, WebRequest request){
          binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
      };
      
      
9.dataType值如果为'json'，jquery就会把后端返回的字符串尝试通过JSON.parse()尝试解析为js对象。    
dataType值如果为'text'，结果弹出框直接显示后台返回的json字符串。       
dataType值如果为'html'，结果弹出框直接显示后台返回的json字符串。

10.thymeleaf 日期转换 #{dates.format(data,'yyyy-MM-dd')}

11.权限的tree utils/ZTreeUtils.

12.权限接口的返回值  是JSONArray  ，需要在pom.xml中引入fastjson

13.添加权限信息
 <insert id="save">
        insert into sys_role_permission (role_id,permission_id) values
        <foreach collection="permissionIds" item="permissionId" separator=",">
           (#{roleId},#{permissionId})
        </foreach>
    </insert>
    
14.
加了contentType  
                type:'get',
                url:'/permission/listAllPermission',
                contentType:'application/json;charset=utf-8',
                async: false,
 SpringBoot接受到http请求后，会根据content-type来判断请求的数据格式，进而利用HttpMessageConverter将数据解析成特定的类型。对应JSON格式的数据，SpringBoot默认使用jackson进行数据的序列化/反序列化;
 
 
 15.jQuery就是用$(document).ready()方法来代替传统的JS的window.onload方法的
 window.onload = function(){
     //编写代码
 }
 jQuery的代码如下：
 
 $(document).ready(function(){
    //编写代码
 })
 
 
 16.$("#show_nickName").text((nickname!=null && nickname!= undefined)?nickname:'---');
 jquery修改INNERHTML
 $("#L_username").val(JSON.parse(localStorage.user).username);
 jquery赋值
 
 17.使用swagger2
    <!-- 引入swagger2 -->
         <dependency>
             <groupId>io.springfox</groupId>
             <artifactId>springfox-swagger2</artifactId>
             <version>2.9.2</version>
         </dependency>
         <dependency>
             <groupId>io.springfox</groupId>
             <artifactId>springfox-swagger-ui</artifactId>
             <version>2.9.2</version>
         </dependency>
         
         
         swaggerconfig配置文件
         
         方法使用：
         @ApiOperation 描述一个类的方法，或者说一个接口
         @ApiOperation(value = "分页获取用户信息",notes = "分页获取用户信息")
         @ApiImplicitParam 一个请求参数
         @ApiImplicitParams 多个请求参数
         