package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
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
        canvas.drawColor(if (isPressed) Color.DKGRAY else buttonColor)
        val textY = height / 2 - (paint.descent() + paint.ascent()) / 2
        canvas.drawText(buttonText, width / 2f, textY, paint)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // El usuario ha presionado el botón
                isPressed = true
                invalidate() // Vuelve a dibujar la vista
            }
            MotionEvent.ACTION_UP -> {
                // El usuario ha levantado el dedo del botón
                isPressed = false
                performClick() // Activa el evento de clic
                invalidate()
            }
        }
        return true
    }

    override fun performClick(): Boolean {
        // Llama al método performClick de la clase base
        return super.performClick()
    }
}