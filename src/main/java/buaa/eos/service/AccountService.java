package buaa.eos.service;
import buaa.eos.mapper.AccountMapper;
import buaa.eos.model.Account;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;



    public int save(Account account) {
        int feedback = 0;
        Example example = new Example(Account.class);

        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("account_name", account.getAccount_name());
        List<Account> result = accountMapper.selectByExample(example);
        if (result.size()>0) {
            account.setId(result.get(0).getId());
            accountMapper.updateByPrimaryKey(account);
        } else {
            accountMapper.insert(account);
            feedback = 1;
        }
        return feedback;
    }

}

