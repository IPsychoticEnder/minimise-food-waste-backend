

import './GenerateButton.css'

import { Link } from 'react-router-dom'

type Props = {}

function GenerateButton({}: Props) {
  return (
    <>
      <button className='button generate-recipes-button'>
          Generate Recipes
      </button>
      <div className='sign-up-link'>
        <p>Or</p>
        <Link className='emphasis-text link' to="/signup">sign up</Link>
        <p>now!</p>
      </div>
    </>
  )
}

export default GenerateButton