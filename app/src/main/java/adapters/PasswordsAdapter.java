package adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.widget.TextView;

import nandyaladeepu.passwordbank.R;
import nandyaladeepu.passwordbank.UserBean;

/**
 * Created by nandyaladeepu on 23/7/14.
 */
public class PasswordsAdapter extends BaseAdapter{
    List<UserBean> uBeans = new ArrayList<UserBean>();
    Context mContext;
    public PasswordsAdapter(Context mContext){
        this.mContext = mContext;
    }
    public PasswordsAdapter(List<UserBean> l, Context mContext){
        uBeans = new ArrayList<UserBean>(l);
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return uBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return uBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View nView = view;
        LayoutInflater l = LayoutInflater.from(mContext);
        if(nView == null){
            nView = l.inflate(R.layout.pwd_item, null);
        }
        UserBean uBean = uBeans.get(i);
        ((TextView)nView.findViewById(R.id.account_name)).setText("Account: "+uBean.getAccountname());
        ((TextView)nView.findViewById(R.id.username)).setText("Name: "+uBean.getName());
        ((TextView)nView.findViewById(R.id.password)).setText("Pwd: "+uBean.getPassword());
        return nView;
    }

    public void setUBeans(List<UserBean> l){
        uBeans = new ArrayList<UserBean>(l);
    }
}
