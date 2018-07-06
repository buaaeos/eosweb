package buaa.eos.service;
import buaa.eos.mapper.AccountMapper;
import buaa.eos.model.Account;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;



    public int save(Account account) {
        int feedback = 0;
        Example example = new Example(accountMapper.class);

        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("account_name", account.getAccount_name());
        if (accountMapper.selectByExample(example).size()>0) {
            feedback = accountMapper.updateByPrimaryKey(account);
        } else {
            feedback = accountMapper.insert(account);
        }
        return feedback;
    }

}

