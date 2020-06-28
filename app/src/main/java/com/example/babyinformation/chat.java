package com.example.babyinformation;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.applozic.mobicomkit.ApplozicClient;
import com.applozic.mobicomkit.api.account.register.RegistrationResponse;
import com.applozic.mobicommons.commons.core.utils.Utils;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

import io.kommunicate.KmConversationBuilder;
import io.kommunicate.KmConversationHelper;
import io.kommunicate.KmException;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KMLoginHandler;
import io.kommunicate.callbacks.KmCallback;
import io.kommunicate.users.KMUser;

public class chat extends AppCompatActivity {

    EditText mUserId, mPassword;
    AppCompatButton loginButton, visitorButton;
    LinearLayout layout;
    boolean exit = false;
    public static final String APP_ID = "237705af941a6fd6d4af3db6ab2f2d6bc";
    private static final String INVALID_APP_ID = "INVALID_APPLICATIONID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Kommunicate.init(this,APP_ID);

        new KmConversationBuilder(chat.this)
                .launchConversation(new KmCallback() {
                    @Override
                    public void onSuccess(Object message) {
                        Log.d("Conversation", "Success : " + message);
                    }

                    @Override
                    public void onFailure(Object error) {
                        Log.d("Conversation", "Failure : " + error);
                    }
                });

//        layout = (LinearLayout) findViewById(R.id.footerSnack);
//        mUserId = (EditText) findViewById(R.id.userId_editText);
//        mPassword = (EditText) findViewById(R.id.password_editText);
//        loginButton = (AppCompatButton) findViewById(R.id.btn_signup);
//        visitorButton = findViewById(R.id.btn_login_as_visitor);
//
//        TextView txtViewPrivacyPolicy = (TextView) findViewById(R.id.txtPrivacyPolicy);
//        txtViewPrivacyPolicy.setMovementMethod(LinkMovementMethod.getInstance());
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    if (isPlaceHolderAppId()) {
//                        return;
//                    }
//                    final String mUserIdText = mUserId.getText().toString().trim();
//                    String mPasswordText = mPassword.getText().toString().trim();
//                    if (TextUtils.isEmpty(mUserIdText) || mUserId.getText().toString().trim().length() == 0) {
//                        Toast.makeText(getBaseContext(), R.string.enter_user_id, Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    final ProgressDialog progressDialog = new ProgressDialog(chat.this);
//                    progressDialog.setTitle("Logging in..");
//                    progressDialog.setMessage("Please wait...");
//                    progressDialog.setCancelable(false);
//                    progressDialog.show();
//                    initLoginData(mUserId.getText().toString().trim(), mPassword.getText().toString().trim(), progressDialog);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        visitorButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isPlaceHolderAppId()) {
//                    return;
//                }
//                final ProgressDialog progressDialog = new ProgressDialog(chat.this);
//                progressDialog.setTitle("Logging in..");
//                progressDialog.setMessage("Please wait...");
//                progressDialog.setCancelable(false);
//                progressDialog.show();
//                Kommunicate.loginAsVisitor(chat.this, new KMLoginHandler() {
//                    @Override
//                    public void onSuccess(RegistrationResponse registrationResponse, Context context) {
//                        finish();
//                        progressDialog.dismiss();
//                        Kommunicate.openConversation(context, null);
//                    }
//
//                    @Override
//                    public void onFailure(RegistrationResponse registrationResponse, Exception exception) {
//                        progressDialog.dismiss();
//                        createLoginErrorDialog(registrationResponse, exception);
//                    }
//                });
//            }
//        });
    }

//    public boolean isPlaceHolderAppId() {
//        if (Kommunicate.PLACEHOLDER_APP_ID.equals(APP_ID)) {
//            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//            dialogBuilder.setCancelable(true);
//            dialogBuilder.setMessage(Utils.getString(this, R.string.invalid_app_id_error));
//            dialogBuilder.show();
//            return true;
//        }
//        return false;
//    }
//
//    public String getInvalidAppIdError(RegistrationResponse registrationResponse) {
//        if (registrationResponse != null) {
//            if (registrationResponse.getMessage() != null && INVALID_APP_ID.equals(registrationResponse.getMessage())) {
//                return getString(R.string.invalid_app_id_error);
//            } else {
//                return registrationResponse.getMessage();
//            }
//        }
//        return "";
//    }
//
//    public void createLoginErrorDialog(RegistrationResponse registrationResponse, Exception exception) {
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//        dialogBuilder.setCancelable(true);
//        StringBuilder message = new StringBuilder(getString(R.string.some_error_occured));
//        if (registrationResponse != null) {
//            if (!TextUtils.isEmpty(getInvalidAppIdError(registrationResponse))) {
//                message.append(" : ");
//                message.append(getInvalidAppIdError(registrationResponse));
//            }
//        } else if (exception != null) {
//            message.append(" : ");
//            message.append(exception.getMessage());
//        }
//
//        dialogBuilder.setMessage(message.toString());
//        dialogBuilder.show();
//    }
//
//    public void showSnackBar(int resId) {
//        Snackbar.make(layout, resId,
//                Snackbar.LENGTH_SHORT)
//                .show();
//    }
//
//    @Override
//    public void onBackPressed() {
//
//        if (exit) {
//            finish();
//        } else {
//            Toast.makeText(this, R.string.press_back_exit, Toast.LENGTH_SHORT).show();
//            exit = true;
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    exit = false;
//                }
//            }, 3000);
//        }
//
//    }
//
//    public void initLoginData(String userId, String password, final ProgressDialog progressDialog) {
//
//        final KMUser user = new KMUser();
//        user.setUserId(userId);
//        user.setApplicationId(APP_ID);
//
//        if (!TextUtils.isEmpty(password)) {
//            user.setPassword(password);
//        }
//
//        Kommunicate.login(chat.this, user, new KMLoginHandler() {
//            @Override
//            public void onSuccess(RegistrationResponse registrationResponse, Context context) {
//                if (KMUser.RoleType.USER_ROLE.getValue().equals(registrationResponse.getRoleType())) {
//                    ApplozicClient.getInstance(context).hideActionMessages(true).setMessageMetaData(null);
//                } else {
//                    Map<String, String> metadata = new HashMap<>();
//                    metadata.put("skipBot", "true");
//                    ApplozicClient.getInstance(context).hideActionMessages(false).setMessageMetaData(metadata);
//                }
//
//                try {
//                    KmConversationHelper.openConversation(context, true, null, new KmCallback() {
//                        @Override
//                        public void onSuccess(Object message) {
//                            if (progressDialog != null && progressDialog.isShowing()) {
//                                progressDialog.dismiss();
//                            }
//                            finish();
//                        }
//
//                        @Override
//                        public void onFailure(Object error) {
//
//                        }
//                    });
//                } catch (KmException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(RegistrationResponse registrationResponse, Exception exception) {
//                if (progressDialog != null && progressDialog.isShowing()) {
//                    progressDialog.dismiss();
//                }
//                createLoginErrorDialog(registrationResponse, exception);
//            }
//        });
//    }
}
