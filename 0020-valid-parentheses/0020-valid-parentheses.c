bool isValid(char* s) {
        char st[100001];
        int top=-1;
        int i;
        for(i=0;s[i]!='\0';i++)
        {
            if(s[i]=='{'|| s[i]=='(' || s[i]=='[')
            {
                st[++top]=s[i];
            }
            else
            {
                if(top!=-1 && (s[i]=='}'&& st[top]=='{'|| s[i]==')' && st[top]=='('|| s[i]==']'&& st[top]=='['))
                {
                    top--;
                }
                else
                {
                    return false;
                }
            }
        }
        return top==-1;
    };