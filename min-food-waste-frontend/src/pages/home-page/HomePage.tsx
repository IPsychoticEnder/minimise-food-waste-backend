import React from 'react'

import PhotoBanner from '../../components/photo-banner/PhotoBanner'
import GenerateButton from '../../components/Home-Page/generate-recipes-button/GenerateButton'

type Props = {}

function HomePage({}: Props): React.ReactNode {
  return (
    <>
      <PhotoBanner/>
      <GenerateButton/>
    </>
  )
}

export default HomePage