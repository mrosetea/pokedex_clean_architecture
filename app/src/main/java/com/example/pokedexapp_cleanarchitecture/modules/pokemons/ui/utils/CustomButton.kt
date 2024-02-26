package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.example.pokedexapp_cleanarchitecture.R

class CustomButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {
    private var buttonColor: Int = Color.BLUE
    private var isPressed: Boolean = false
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var buttonText: String = "?"
    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButton )
        buttonColor = typedArray.getColor(R.styleable.CustomButton_buttonColor, Color.BLUE)
        buttonText = typedArray.getString(R.styleable.CustomButton_buttonText) ?: "?"
        typedArray.recycle()
        paint.color = buttonColor
        paint.textSize = resources.getDimensionPixelSize(org.koin.android.R.dimen.abc_text_size_display_1_material).toFloat()
        paint.textAlign = Paint.Align.CENTER
    }
    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(if (isPressed) Color.GRAY else Color.DKGRAY)
        val textY = height / 2 - (paint.descent() + paint.ascent()) / 2
        canvas.drawText(buttonText, width / 2f, textY, paint)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                isPressed = true
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                isPressed = false
                performClick()
                invalidate()
            }
        }
        return true
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
    }
}