package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // tested the code on play.kotlin.org
    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers


    /*
    private fun getTestDataArray() : List<Int> {

        val testArray = MutableList(10){ Random.nextInt()}
        testArray.sort()
        return testArray
    }
    */
    //this is the one i attempted in lab but its not a scope
    //private fun getTestDataArray() = (MutableList(10){Random.nextInt()}).sort()
    private fun getTestDataArray() = MutableList(10){Random.nextInt()}.apply{sort()}

    // Return true if average value in list is greater than median value, false otherwise
    /*
    private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean {
        val avg = listOfNumbers.average()
        val sortedList = listOfNumbers.sorted()
        val median = if (sortedList.size % 2 == 0)
            (sortedList[sortedList.size / 2] + sortedList[(sortedList.size - 1) / 2]) / 2
        else
            sortedList[sortedList.size / 2]

        return avg < median
    }

     */

    private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean = listOfNumbers.average() < run{
        val sortedList = listOfNumbers.sorted()
        if (sortedList.size % 2 == 0)
            (sortedList[sortedList.size / 2] + sortedList[(sortedList.size - 1) / 2]) / 2
        else
            sortedList[sortedList.size / 2]
    }



    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)


    /*
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View {
        val textView: TextView

        if (recycledView != null) {
            textView = recycledView as TextView
        } else {
            textView = TextView(context)
            textView.setPadding(5, 10, 10, 0)
            textView.textSize = 22f
        }

        textView.text = collection[position].toString()
        return textView
    }
     */


    /*
    //this is the one i attempted in lab
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View = run{
        val textView: TextView

        if (recycledView != null) {
            textView = recycledView as TextView
        } else {
            textView = TextView(context)
            textView.setPadding(5, 10, 10, 0)
            textView.textSize = 22f
        }
    }.apply{ val textView.text = collection[position].toString()
    }

     */

    // this was from the lecture on 10/12/2023
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context) = if(recycledView !=null){
            recycledView as TextView
        }
        else{
            TextView(context).apply {
                setPadding(5,10,10,0)
                textSize = 22f
            }.apply {text = collection[position].toString()}
        }

    }

}