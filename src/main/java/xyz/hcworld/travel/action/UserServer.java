package xyz.hcworld.travel.action;




import org.springframework.stereotype.Service;
import xyz.hcworld.travel.model.spots.Comment;
import xyz.hcworld.travel.model.spots.Spots;
import xyz.hcworld.travel.model.user.User;
import xyz.hcworld.travel.util.DBUtil;


import java.text.SimpleDateFormat;
import java.util.*;

import static xyz.hcworld.travel.lib.Lib.*;

/**
 * 用户信息登陆注册修改模块
 * @author: 张红尘
 * @date: 2018/4/17 11:16
 */
@Service
public class UserServer{

    /**
     * 登陆验证功能呢
     * @param username 用户名
     * @param password 密码
     * @return 返回用Map封装的用户信息
     */
    public Map isValidPassword(String username,String password) {
        //获取要登录的对象
        User uuser =DBUtil.dbUtil.userService.findByUsernameAndPassword(username,password);
        return (uuser!=null)?isValidInfo(uuser.getUsername(),uuser.getNetname(),uuser.getSex(),uuser.getEmail(),uuser.getPhone(),uuser.getCreatetime()):null;
    }

    /**
     * 注册验证功能
     * @param userinfo 用户信息
     * @return 返回用Map封装的用户信息
     */
    public Map isValidRegister(User userinfo) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        List<User> uuser = DBUtil.dbUtil.userService.findByUsernameOrNetname(userinfo.getUsername(),userinfo.getNetname());
        //用户名或者网名被注册时
        if(uuser.size()>0){
            return null;
        }else {
            //设置注册时间
            userinfo.setCreatetime(date);
            //存进数据库
            DBUtil.dbUtil.userService.save(userinfo);
            //返回要生成数据的MAP
            return isValidInfo(userinfo.getUsername(),userinfo.getNetname(),null,null,null,date);
        }
    }

    /**
     * 修改用户信息
     * @param map 前端传来的用户信息
     * @return 返回修改是否成功，成功true 失败false
     */
    public boolean isValidModify(Map<String,String> map){
        User user = DBUtil.dbUtil.userService.findByName(map.get(USERNAME));
        user.setNetname(map.get(NETNAME));
        user.setSex(map.get(SEX));
        user.setEmail(map.get(EMAIL));
        user.setPhone(map.get(PHONE));
        System.out.println(user.toString());

        return DBUtil.dbUtil.userService.updata(user);
    }
    /**获得用户评论*/
    public List<Map> isValidUserCommentInfo(String netname) {
        List<Comment> spotsInfo=  DBUtil.dbUtil.commentSerivce.findByNetName(netname);
        List<Spots> spotsList= DBUtil.dbUtil.spotsService.findAll();
        Collections.reverse(spotsInfo);
        Map spotslistid = new HashMap();
        //用景点ID作为Key，用名字做Value
        spotsList.forEach((a)-> spotslistid.put(a.getId(),a.getSpots()));


        List<Map> info = new ArrayList<>();
        spotsInfo.forEach((a)->{
            info.add(new HashMap(){{
                put("id",a.getId());
                put("content",a.getContent());
                put("spotes",spotslistid.get(a.getSpotsId()));
            }});
        });


        return info;
    }
    public void isValidUserSetComment(String netname,String comment,Long spotsid) {
        Long a= 1L;
        Comment comment1=  new Comment();
        comment1.setContent(comment);
        comment1.setUserName(netname);
        comment1.setSpotsId(spotsid);
        comment1.setFatherId(a);

        DBUtil.dbUtil.commentSerivce.save(comment1);
    }


    /**用户信息放进MAP*/
    public Map<String,String> isValidInfo(String userName,String netName,String sex,String email,String phone,String createTime) {
        Map<String, String> userinfo = new HashMap<>(11);
        if(userName!=null){userinfo.put(USERNAME, userName);}
        if(userName!=null){userinfo.put(NETNAME, netName);}
        if(userName!=null){userinfo.put(SEX, sex);}
        if(userName!=null){userinfo.put(EMAIL, email);}
        if(userName!=null){userinfo.put(PHONE, phone);}
        if(userName!=null){userinfo.put(CREATETIME, createTime);}
        return userinfo;
    }


}
