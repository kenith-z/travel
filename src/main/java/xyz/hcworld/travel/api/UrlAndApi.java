package xyz.hcworld.travel.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import xyz.hcworld.travel.action.SpotsServer;
import xyz.hcworld.travel.action.UserServer;
import xyz.hcworld.travel.filter.JwtAuthenticationFilter;
import xyz.hcworld.travel.model.spots.Comment;
import xyz.hcworld.travel.model.spots.Spots;
import xyz.hcworld.travel.model.token.Token;
import xyz.hcworld.travel.model.token.TokenResult;


import xyz.hcworld.travel.model.user.User;
import xyz.hcworld.travel.util.JwtUtil;
import xyz.hcworld.travel.util.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static xyz.hcworld.travel.lib.Lib.*;



/**
 * Url接口
 * @author: 张红尘
 * @date: 2018/4/19 0:18
 */
@RestController
public class UrlAndApi {
    /**用户信息登陆注册修改模块*/
    @Autowired
    private UserServer userServer;
    /**景点介绍及评论模块*/
    @Autowired
    private SpotsServer spotsServer;


    /**
     * jwt过滤器
     *
     */
    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilter() {
        final FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }

    /**
     * 获得用户信息
     *
     * @author: 张红尘
     * @date: 2018/4/19
     **/
    @GetMapping("/user/usertokeninfo")
    public @ResponseBody
    Object usertokeninfo(@RequestHeader(value = USERNAME) String userName,
                     @RequestHeader(value = NETNAME) String netName,
                     @RequestHeader(value = SEX) String sex,
                     @RequestHeader(value = EMAIL) String email,
                     @RequestHeader(value = PHONE) String phone,
                     @RequestHeader(value = CREATETIME) String createTime
            ) {

        return new HashMap<String,String>(8){{
            put(USERNAME,userName);
            put(NETNAME,netName);
            put(SEX,sex);
            put(EMAIL,email);
            put(PHONE,phone);
            put(CREATETIME,createTime);
        }
        };
    }
    /**获取用户自己的所有评论*/
    @GetMapping("/user/usercomment")
    public @ResponseBody
    List<Map> usercomment(@RequestHeader(value = NETNAME) String netName) {

        return userServer.isValidUserCommentInfo(netName);
    }

    /**发表评论*/
    @PostMapping("/user/setcomment")
    public@ResponseBody
    boolean stecomm(@RequestHeader(value = NETNAME) String netName, @RequestBody Comment comment) {

        String comm=Unit.jsSecurity(comment.getContent());
        userServer.isValidUserSetComment(netName,comm,comment.getSpotsId());
        return true;
    }
    /**add
     * &#x4fee;&#x6539;&#x7528;&#x6237;&#x4fe1;&#x606f;
     * @param userName token&#x7684;&#x7528;&#x6237;&#x540d;
     * @param createTime token&#x7684;&#x7528;&#x6237;&#x521b;&#x5efa;&#x65f6;&#x95f4;&#x4fe1;&#x606f;
     * @param user &#x524d;&#x7aef;&#x4f20;&#x6765;&#x7684;json&#x4fe1;&#x606f;&#x6620;&#x5c04;&#x5230;User&#x5bf9;&#x8c61;
     * @return Map
     */
    @PostMapping("/user/modify")
    public @ResponseBody
    Map<String, Object> modifyUserInfo(
                    @RequestHeader(value = NETNAME) String netname,
                    @RequestHeader(value = USERNAME) String userName,
                     @RequestHeader(value = CREATETIME) String createTime,
                    @RequestBody User user
    ) {
        //
        Map<String, String> userinfo = userServer.isValidInfo(userName,netname,user.getSex(),user.getEmail(),user.getPhone(),createTime);
        if(userServer.isValidModify(userinfo)){
            String jwt = JwtUtil.generateToken(userName,userinfo);
            TokenResult tokenResult = new TokenResult(new Token(jwt, "86400", "Bearer"));
            return new HashMap<String, Object>(3) {{
                put("statusCode", "000003");
                put("desc", "修改成功");
                put("result", tokenResult);
            }};
        }else {
            return new HashMap<String, Object>(3) {{
                put("statusCode", "111004");
                put("desc", "用户信息修改失败");
                put("result", "");
            }};
        }
    }

    /**
     *登陆
     * @author: 张红尘
     * @date: 2018/4/19
     **/
    @PostMapping("/user/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody User user)  {
        //取数据库数据
        Map llogin= userServer.isValidPassword(user.getUsername(),user.getPassword());

        //账号密码都正确的时候
        if (llogin!=null) {
            String jwt = JwtUtil.generateToken(user.getUsername(),llogin);
            //生成token
            TokenResult tokenResult = new TokenResult(new Token(jwt, "86400", "Bearer"));
            //返回json格式的信息
            return new HashMap<String, Object>(3) {{
                put("statusCode", "000000");
                put("desc", "登录成功");
                put("result", tokenResult);
            }};
        } else {
            //账号密码都错误的时候
            return new HashMap<String, Object>(3) {{
                put("statusCode", "111001");
                put("desc", "用户密码错误/用户不存在");
                put("result", "");
            }};
        }
    }
    /**
     *注册
     * @author: 张红尘
     * @date: 2018/4/19
     **/
    @PostMapping("/user/register")
    @ResponseBody
    public Map<String, Object> register(@RequestBody User user)  {
        Map mUserinfo= userServer.isValidRegister(user);

        //账号密码都正确的时候
        if (mUserinfo!=null) {
            String jwt = JwtUtil.generateToken(user.getUsername(),mUserinfo);
            TokenResult tokenResult = new TokenResult(new Token(jwt, "86400", "Bearer"));
            return new HashMap<String, Object>(3) {{
                put("statusCode", "000001");
                put("desc", "注册成功");
                put("result", tokenResult);
            }};
        } else {
            //账号密码都错误的时候
            return new HashMap<String, Object>(3) {{
                put("statusCode", "111002");
                put("desc", "用户名或账号已存在");
                put("result", "");
            }};
        }
    }

    /**主页景点列表*/
    @GetMapping("/spots/list")
    @ResponseBody
    public List<Spots> getSpots(){
        return spotsServer.isValidSpotsList();
    }

    /**景点详细信息和评论*/
    @GetMapping("/spots/Info")
    @ResponseBody
    public List getSpotsInfo(Long id){
        return new ArrayList() {{
           add(spotsServer.isValidSpotsInfo(id));
           add(spotsServer.isValidSpotsCommentInfo(id));
        }};
    }
    /**住宿列表*/
    @GetMapping("/hotel/list")
    @ResponseBody
    public List getHotel(Long id){
        List<Spots> list=  spotsServer.isValidSpotsList();
        List<Map> spli = new ArrayList<>();

        list.forEach((a)->{
            spli.add(new HashMap(3){{
                put("id",a.getId());
                put("spots",a.getSpots());
            }});
        });
        return new ArrayList() {{
            add(spli);
            add(spotsServer.isValidHotelList(id)) ;
        }};
    }

    /**景点详细信息和评论*/
    @GetMapping("/hotel/Info")
    @ResponseBody
    public List getHotelInfo(Long id){
        List<Spots> list=  spotsServer.isValidSpotsList();
        List<Map> spli = new ArrayList<>();

        list.forEach((a)->{
            spli.add(new HashMap(3){{
                put("id",a.getId());
                put("spots",a.getSpots());
            }});
        });
        return new ArrayList() {{
            add(spli);
            add(spotsServer.isValidHotelInfo(id));
            add(spotsServer.isValidHotelCommentInfo(id));
        }};
    }

}
