package cn.wxs.limitServiceImpl;

import cn.dao.MenuDao;
import cn.pojo.Menu;
import cn.wxs.limitService.LimitService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LimitServiceImpl implements LimitService {
    @Autowired
    private MenuDao md;
    public MenuDao getMd() {
        return md;
    }
    public void setMd(MenuDao md) {
        this.md = md;
    }
    /**
     * 插件显示分页
     * @param index 页码
     * @param pagesize 显示条数
     * @return
     */
    public String getPageByIndex(int index, int pagesize) {
        PageHelper.startPage(index,pagesize);
        List<Menu> allMenu = md.getAllMenu(null);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(allMenu);
        return  JSON.toJSONString(pageInfo);

    }
}
