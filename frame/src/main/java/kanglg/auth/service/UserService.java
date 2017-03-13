package kanglg.auth.service;

import kanglg.auth.dao.ResDao;
import kanglg.auth.dao.RoleDao;
import kanglg.auth.dao.UserDao;
import kanglg.auth.entity.BSysUser;
import kanglg.util.EndecryptUtils;
import kanglg.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * 定义用户权限的各种方法
 * Created by kanglg on 2017/2/20.
 */
@Service
@Transactional
public class UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final ResDao resDao;

    @Autowired
    public UserService(UserDao userDao, RoleDao roleDao, ResDao resDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.resDao = resDao;
    }

    /**
     * 根据ID查找用户
     * @param id ID
     * @return 用户
     */
    public BSysUser findUser(String id) {
        return userDao.findOne(id);
    }

    /**
     * 根据账户名查找用户
     * @param account 账户名
     * @return 用户
     */
    public BSysUser findUserByAccount(String account) {
        return userDao.findByUserAccount(account);
    }

    /**
     * 根据账号查找用户角色集合
     * @param account 账号名
     * @return 角色集合
     */
    public Set<String> findRoles(String account) {
        return roleDao.findByAccount(account);
    }

    /**
     * 根据账号查找用户权限描述
     * @param account 账号名
     * @return 权限描述集合
     */
    public Set<String> findPermissions(String account) {
        return resDao.findPermissionByAccount(account);
    }

    /**
     * 添加用户
     * @param user 用户
     * @return 持久化用户
     */
    public BSysUser addUser(BSysUser user) {
        user.setUserId(RandomUtils.uuid());
        user.setUserPassword(EndecryptUtils.MD5Password(user.getUserPassword(), user.getUserAccount()));
        return userDao.save(user);
    }

    public List<BSysUser> findAll() {
        return (List<BSysUser>) userDao.findAll();
    }
}
