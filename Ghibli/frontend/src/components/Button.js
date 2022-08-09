import React from "react";
import './Button.css'

const STYLES = [
    'btn--primary',
    'btn--outline'
]

const SIZES = [
    'btn--medium',
    'btn--large'
]

export const Button=({
    children,
    type,
    onClick,
    buttonStyle,
    buttonSize
}) =>{
    const checkButtonStyle = Styles.includes(buttonStyle) ? buttonStyle:STYLES[0]
    const checkButtonSize = Styles.includes(buttonSize) ? buttonStyle:SIZES[0]

    return(
        <button className={`btn ${checkButtonStyle} ${checkButtonSize}`} onClick={onClick}
        type={type}>
            {children}
        </button>
    )
}