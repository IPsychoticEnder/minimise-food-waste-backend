import React from 'react'

import ReusableBlur from '../../reusable-blur/ReusableBlur'
import SignUpForm from '../../sign-up-form/SignUpForm'

import './GenerateButton.css'

type Props = {}

function GenerateButton({}: Props) {
  return (
    <>
      <button className='button generate-recipes-button'>
          Generate Recipes
      </button>
      <div className='sign-up-link'>
        <p>Or</p>
        <ReusableBlur
          trigger={<p className='emphasis-text'>sign up</p>}
        >
          <SignUpForm/>
        </ReusableBlur>
        <p>now!</p>
      </div>
    </>
  )
}

export default GenerateButton