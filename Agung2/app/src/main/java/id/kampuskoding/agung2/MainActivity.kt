package id.kampuskoding.agung2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        var list = mutableListOf<Model>()

        list.add(Model("Ruby",   "Ruby is open-source and fully object-oriented programming language",   R.drawable.ruby  ))
        list.add(Model("Rails",   "Ruby on Rails is a server-side web application development framework written in Ruby language", R.drawable.rails ))
        list.add(Model("Python", "Python is interpreted scripting and object-oriented programming language", R.drawable.python  ))
        list.add(Model("Java Script",  "JavaScript is an object-oriented programming language",  R.drawable.javascript  ))
        list.add(Model("PHP",  "PHP is  an interpreted language, i.e., there is no need for compilation",  R.drawable.php  ))

        listView.adapter = MyListAdapter(this,R.layout.row,list)

        listView.setOnItemClickListener { parent, view, position, id ->


            if (position == 0) {
                Toast.makeText(this@MainActivity, "Ruby", Toast.LENGTH_SHORT).show()
            }
            if (position == 1) {
                Toast.makeText(this@MainActivity, "Rails", Toast.LENGTH_SHORT).show()
            }
            if (position == 2) {
                Toast.makeText(this@MainActivity, "Python", Toast.LENGTH_SHORT).show()
            }
            if (position == 3) {
                Toast.makeText(this@MainActivity, "Java Script", Toast.LENGTH_SHORT).show()
            }
            if (position == 4) {
                Toast.makeText(this@MainActivity, "PHP", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
