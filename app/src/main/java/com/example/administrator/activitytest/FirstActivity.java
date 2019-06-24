package com.example.administrator.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        /*
        *   1、元素的获取
        *   2、按钮的事件
        *   3、Toast提示的使用
        */
        Button button1 = (Button)findViewById(R.id.button_1);
        /*为按钮添加点击监听事件*/
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*
                * 创建、并获取一个Toast对象：
                * Toast的静态方法makeTest可以创建并获取Toast对象，
                * makeTest静态方法的三个参数(上下文件对象，显示的内容，显示时长)
                * 此类本身继承了AppCompatActivity，而这个AppCompatActivity祖先中有一个就是Context,所以此类本身就是上下文对象
                * Toast中定义了两个变量来指定时长
                *   public static final int LENGTH_LONG = 1;
                *   public static final int LENGTH_SHORT = 0;
                * */
                Toast toast = Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT);
                toast.show();
           }
        });

        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*finish方法销毁此活动，相当于手机本身的Back返回按钮*/
                finish();
            }
        });

        Button button3 = (Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*使用意图相关的类Intent来访问别的活动(页面)----------显示模式
                * 两个参数：
                * 参数一：执行意图的上下文
                * 参数二：准备访问的活动类
                * */
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button button4 = (Button)findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*使用意图相关的类Intent来访问别的活动(页面)----------隐式示模式
                 * */
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                startActivity(intent);
            }
        });

        Button button5 = (Button)findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*使用意图相关的类Intent来访问别的活动(页面)----------隐式示模式
                 * */
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        Button button6 = (Button)findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*调用其它的活动页面
                 * 注意，如果AndroidManifest.xml中配制Activity时，
                 *      如果配制了【<action android:name="android.intent.action.VIEW"/>】
                 * 有可能让你选择使用哪种方式打开
                 * */
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button button7 = (Button)findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*调用系统拨号界面对话框(活动Activity)
                 * */
                /*Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

                //调出地图
                /*
                方法一：
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:34.042116,113.85325"));
                startActivity(intent);
                方法二：
                Uri uri = Uri.parse("geo:34.042116,113.85325");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                */
            }
        });

        Button button8 = (Button)findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*访问别的活动、并且传递数据
                 * */
                String data = "Hello FourthActivity";
                Intent intent = new Intent(FirstActivity.this, FourthActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });

        Button button9 = (Button)findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*访问别的活动、并且传递数据、同时接收返回的数据
                 * 使用startActivityForResult方法而非startActivity方法
                 * 使用startActivityForResult方法的同时指定requestCode，用来定位是那个活动的请求
                 *
                 * 接收返回的数据不是在这里，而是需要重写onActivityResult方法，在方法中获取返回值
                 * */
                String data = "Hello FourthActivity";
                Intent intent = new Intent(FirstActivity.this, FourthActivity.class);
                intent.putExtra("extra_data", data);
                startActivityForResult(intent, 1001);
            }
        });

    }

    /*
    * 如果想让活动页面右上角显示三个点击弹出按钮，需要重写onCreateOptionsMenu方法：
    **【调出重写方法的快捷键为-> Ctrl + O】
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*getMenuInflater方法获取一个MenuInflater对象：
        *   MenuInflater对象的inflate方法为活动指定菜单
        * */
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /*为菜单指定选择事件，重写onOptionsItemSelected方法:
    * 参数item为选择的菜单，
    * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }

    /** 接收活动返回的数据 */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1001:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",   "FirstActivity : 1001 接收返回数据---------------------------------------------" + returnedData);
                }
                break;
            default:
        }
    }
}


/*活动：
* 1、创建项目时默认选中自动创建主活动及对应的布局。
* 2、可以手动创建一个空项目，及创建项目同时不创建活动。
* 3、创建完项目，手动创建一个活动FirstActivity，但是有下列三个选项，前两个选项先不要选择
*   选项一、Generate Layout File : 自动为此活动创建一个对应的布局文件
*   选项二、Launcher Activity : 表示自动将此活动设置为当前项目的主活动
*   选项三、Backwards Compatibility : 向下兼容
* 4、创建的活动
*   自动继承了AppCompatActivity类，
*   自动重写了onCreate()方法。
* 5、创建布局
*   创建布局时，选择根元素【LinearLayout】(常用的线性布局)
*   修改属性值
*   根元素下面添加其它元素，比如说按钮、文本框等
* 6、加载布局，及把布局加载到活动中
*   项目中添加的任何资源都会在R文件中生成一个相应的资源id。
*   setContentView(布局ID)。
* 7、活动注册
*   活动要在【AndroidManifest.xml】中注册才能生效
*   创建完活动之后，会自动在其中注册
*   android:name=".FirstActivity"，即注册创建的活动，
*       父标签已经引入命名空间路径package="com.example.administrator.activitytest"
*       android:name=".FirstActivity"直接跟在全名空间后面。
*   如果是主活动的话，需要配制主活动
*       <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
*   为主活动设置标题(显示在活动的标题栏部分)
*       android:label="This is FirstActivity"
*       如果是主活动，此标题名称还会成为程序的名称
* */
/*根据ID查找元素
*   Button button1 = (Button)findViewById(R.id.button_1);
*       Button按钮元素同样是View，需要把View强转为按钮
*       R.id.button_1是在布局中为按钮设置的ID
* */
/*为元素添加事件，添加点击监听事件
*    button1.setOnClickListener(new View.OnClickListener(){
*       @Override
*       public void onClick(View view) {
*           具体操作;
*       }
*    });
* */
/*在活动中使用Toast
 *
 * Toast toast = Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT);
 * toast.show();
 *
 * 创建、并获取一个Toast对象：
 * Toast的静态方法makeTest可以创建并获取Toast对象，
 * makeTest静态方法的三个参数(上下文件对象，显示的内容，显示时长)
 * 此类本身继承了AppCompatActivity，而这个AppCompatActivity祖先中有一个就是Context,所以此类本身就是上下文对象
 * Toast中定义了两个变量来指定时长
 *   public static final int LENGTH_LONG = 1;
 *   public static final int LENGTH_SHORT = 0;
 */

/*菜单的创建
*   充分挖掘手机的空间
*   在手机的右上角生成三个点，点击会弹出菜单
*   首先需要在res包下面创建menu文件夹，然后在menu下创建菜单布局(根标签为menu)
*       其中一个item元素就是一个菜单项
*   在需要菜单的活动中重写菜单方法、并且引入菜单布局，即可获取出现菜单
*       重写菜单方法onCreateOptionsMenu
*       初始化getMenuInflater().inflate(R.menu.main, menu);
*           getMenuInflater方法获取一个MenuInflater对象：
*           MenuInflater对象的inflate方法为活动创建菜单
*           inflate(菜单布局, 为哪个菜单添加menu);//这里的当然就是当前活动的menu
* */
/*菜单事件
*   在活动中重写onOptionsItemSelected方法
*   在重写的方法中，根据选择的菜单ID，为其指定基体操作
* */

/*销毁一个活动
*   安卓机器自带的back按键
*   使用【finish();】方法，把此方法写在一个按钮事件上。
* */


/*使用Intent在活动中穿梭(即，活动间的切换)
*   显式Intent(指要跳转到哪一个具体的活动)
*       Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
*           第一个参数为上下文(一般指本活动)
*           第二个参数为准备跳转到的活动
*       startActivity(intent);//执行
*   隐式Intent(需要配合活动在AndroidManifest.xml中的配制)
*       配制中，<action 指定活动/>，<category 指定附加信息/>
*       【
*           配制：
*           <activity android:name=".SecondActivity" android:label="This is SecondActivity">
*                <intent-filter>
*                   <action android:name="com.example.activitytest.ACTION_START" />
*                   <category android:name="android.intent.category.DEFAULT" />
*               </intent-filter>
*           </activity>
*
*           使用隐式Intent查找活动
*           Intent intent = new Intent("com.example.activitytest.ACTION_START");
*           //如果配制中使用的是DEFAULT，下面这句话可以省略，系统会自动添加
*           //intent.addCategory("android.intent.category.DEFAULT");
*           startActivity(intent);
*       】
*       更多隐式用法：
*       【  打开外部页面：
*           在程序AndroidMainfest.xml中如果没有对应的设置，下面语句会直接打开请求
*               Intent intent = new Intent(Intent.ACTION_VIEW);
*               intent.setData(Uri.parse("https://www.baidu.com"));
*               startActivity(intent);
*
*           如果在AndroidMainfest.xml刚好有对应的过滤，打开连接时会出现对应的选择（有了这两个条件才会出现选择界面，否则直接默认程序打开）
*           1、配制了<action android:name="android.intent.action.VIEW" />
*           2、进行数据过滤<data android:scheme="https" />
*               <activity android:name=".ThirdActivity" android:label="This is ThirdActivity">
*                    <intent-filter>
*                        <action android:name="android.intent.action.VIEW" />
*                        <category android:name="android.intent.category.DEFAULT" />
*                        <!-- 如果配制了下面这一项，会选择默认的浏览器打开此页面【和没有配制此activity是一样的】-->
*                        <!-- <category android:name="android.intent.category.BROWSABLE"/> -->
*                        <!-- 如果访问的数据以(https)开头就会被过滤。如上面的访问方式访问(https://www.baidu.com) -->
*                        <data android:scheme="https" />
*                    </intent-filter>
*                </activity>
*       】
*       【调用系统拨号界面对话框(活动Activity)：
*           Intent intent = new Intent(Intent.ACTION_DIAL);
*           intent.setData(Uri.parse("tel:10086"));
*           startActivity(intent);
*       】
*       【调出地图
*           Intent intent = new Intent(Intent.ACTION_VIEW);
*           intent.setData(Uri.parse("geo:34.042116,113.85325"));
*           startActivity(intent);
*       】
*       【发信息、发邮件、播放、安装、卸载等，参考(https://blog.csdn.net/qq_36497605/article/details/54907733?locationNum=3&fps=1)】
* */

/*向下一活动传递数据：
*   只需要在Intent中添加数据即可(其它一切照旧)
*       String data = "Hello FourthActivity";
*       intent.putExtra("extra_data", data);
*   在接收数据的活动中也很简单：
*       Intent intent = getIntent();
*       String data = intent.getStringExtra("extra_data");
* */

/*返回数据给上一活动：
*   在不接收返回数据的情况下使用【startActivity(intent);】指向下一活动。
*   如果想接收下一活动返回的数据使用【startActivityForResult(intent, 返回码);】
*       1、使用【startActivityForResult(intent, 返回码);】指向下一活动
*       2、重写【onActivityResult】方法，通过判断“返回码”确定是返回的哪项数据
*   下一活动需要做的事情：
*       一、自定义按钮返回
*       finish方法返回上一级，同时返回数据给上一级调用(方法：setResult)
*       方法：setResult接收两个参数(Ok或CANCELED， Intent)
*           Intent intent1 = new Intent();
*           intent1.putExtra("data_return", "Hello FirstActivity");
*           setResult(RESULT_OK, intent1);
*           finish();
*       二、系统自有的back按键
*       如果没有按钮，而是点击的手机自带的back按钮，需要重写onBackPressed方法
*           @Override
*           public void onBackPressed() {
*               Intent intent = new Intent();
*               intent.putExtra("data_return", "Hello FirstActivity");
*               setResult(RESULT_OK, intent);
*               finish();
*           }
* */


/*活动的生命周期：
*   返回栈 ： 后进先出
*   活动状态：
*       运行状态
*       暂停状态
*       停止状态
*       销毁状态
*   活动的生命周期 ： 可以通过重写相应的方法来测试
* */



