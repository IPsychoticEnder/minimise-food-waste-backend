import React from 'react'

import SignUpForm from './SignUpForm'
import SignupPageBanner from './signupPageBanner'

import './SignUpPage.css'


function SignUpPage() {
  return (
    <div className='signup-page'>
        <SignUpForm/>
        <SignupPageBanner/>
    </div>
  )
}

export default SignUpPage