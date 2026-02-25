import React from 'react'

type Props = {}

function SignUpForm({}: Props) {
  return (
    <div className='form'>
        <p className='title'>Register now!</p>

        <form className='form-container'>
            <input type='email' placeholder='Email' className='input-field'/>
            <input type='password' placeholder='Choose password' className='input-field'/>

            <button className='button'>Login</button>
        </form>
    </div>
  )
}

export default SignUpForm