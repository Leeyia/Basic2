# Basic2
u can efficient development code use basic2 android architecture components

# Usage
```
public class LoginAct extends AbsLifecycleActy implements View.OnClickListener {

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_login);
        findViewById(R.id.req).setOnClickListener(this);

        viewModel = ViewModelProviders
                .of(this, ViewModelUtil.createFor(LoginViewModel.create(ApiFactory.serv())))
                .get(LoginViewModel.class);
    }

    @Override
    public void onClick(View view) {
        ReqMap requMap = new ReqMap()
                .put("username", "1771092****")
                .put("password", "1234@abcd");

        viewModel
                .login(requMap)
                .observe(this, new Observer<Resource<Token>>() {
                    @Override
                    public void onChanged(@Nullable Resource<Token> tokenResource) {
                        Log.d("token", "onChange =" + tokenResource.data.toString());
                    }
                });
    }
}
```

# License
```
Copyright (C) 2017 meikoz, http://basic2it.cc/

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
