package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcPersonPicture;
import com.healt.cloud.checkup.service.HcPersonPictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.HcPersonPictureMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人信息图片 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-08-10
 */
@Service
public class HcPersonPictureServiceImpl extends ServiceImpl<HcPersonPictureMapper, HcPersonPicture> implements HcPersonPictureService {

	private static final long serialVersionUID = 1L;
}
