/*
 * FreeOTP
 *
 * Authors: Nathaniel McCallum <npmccallum@redhat.com>
 *
 * Copyright (C) 2014  Nathaniel McCallum, Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fedorahosted.freeotp.add;

import org.fedorahosted.freeotp.R;
import org.fedorahosted.freeotp.Token;
import org.fedorahosted.freeotp.Token.TokenUriInvalidException;
import org.fedorahosted.freeotp.TokenPersistence;

import android.app.Activity;
import android.widget.Toast;


public abstract class BaseActivity extends Activity {
    protected void onTokenURI(String uri) {
        try {
            if (uri != null)
                new TokenPersistence(this).add(new Token(uri));
            finish();
        } catch (TokenUriInvalidException e) {
            Toast.makeText(this, R.string.invalid_token, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
